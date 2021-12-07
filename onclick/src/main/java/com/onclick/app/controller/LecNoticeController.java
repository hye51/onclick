package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.NoticeService;
import com.onclick.app.service.StudentService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class LecNoticeController { //과목 공지사항 컨트롤러

	@Autowired
	LecService ls;
	
	@Autowired
	LecNoticeService lns;

	@Autowired
	FileService fs;
	
	@Autowired
	NoticeService ns;
	
	@Autowired
	StudentService ss;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value="/noticeList.do")
	public String lecNoticeList(@RequestParam("lidx") String lidx, Model model, HttpSession session) {
		//강의 공지사항 목록
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//강의 이름 가져오기
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		ArrayList<LecNoticeVO> lnList = lns.lecNoticeSelectAll(Integer.parseInt(lidx));		
		model.addAttribute("lnList", lnList);
		
		return "lecture/noticeList";
	}
	
	
	@RequestMapping(value="/lecNoticeContent.do")
	public String lecNoticeContents(@RequestParam("lnidx") int lnidx,
									HttpSession session, Model model) {
		//강의 공지사항 내용보기
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//강의 이름 가져오기
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		//파일 인덱스 있는 경우 FileVO 세션에 담기
		if((Integer)lnv.getFidx() != null) { 
			FileVO fv = fs.fileSelectAll(lnv.getFidx());
			session.setAttribute("fv", fv);
		}
		
		return "lecture/noticeContent";
	}
	
	
	@RequestMapping(value="/lecNoticeWrite.do")
	public String lecNoticeWrite(HttpSession session, Model model) {
		//과목 공지사항 작성 화면
		int pidx = (Integer)session.getAttribute("pidx");
		//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		return "lecture/noticeUpload";
	}

	@RequestMapping(value="/lecNoticeWriteAction.do")
	public String lecNoticeWriteAction(@RequestParam("lecNotSubject") String lnsubject,
										@RequestParam("lecNotContents") String lncontents,
										@RequestParam("lecNotFile") MultipartFile lnfile,
										@RequestParam("lecNotNotice") String lndelyn,
										HttpSession session) throws Exception {
		//과목 공지사항 작성 완료
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		
		String str = null;
		
		if(lnfile.isEmpty()) { // 첨부파일 없는 경우 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lidx", lidx);
			hm.put("fidx", null);
			
			int value = lns.lecNoticeInsert(hm);
			//insert된 강의 공지사항 인덱스 받아오기
			int lnidx = Integer.parseInt(String.valueOf(hm.get("lnidx")));
			
			if(value == 1) { //insert 성공
				if(lndelyn.equals("Y")) {
					//공지사항 알림 
					String pname= (String)session.getAttribute("pname");
					int cnt = ns.alarmNoticeInsert(lidx, lnidx, pname);					
				}
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNoticeWrite.do";
			}
			
		} else { //첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = lnfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			//저장된 이름
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, lnfile.getBytes());
			
			HashMap<String, Object> lecNoticeFile = new HashMap<String, Object>();
			lecNoticeFile.put("originName", originalFileName);
			lecNoticeFile.put("savedName", savedName);
			lecNoticeFile.put("originalFileExtension", originalFileExtension);
			lecNoticeFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lidx", lidx);
			
			int value = lns.lecNoticeAndFileInsert(hm, lecNoticeFile);
			//insert된 강의 공지사항 인덱스 받아오기
			int lnidx = Integer.parseInt(String.valueOf(hm.get("lnidx")));
			
			if(value == 2) { //insert 성공
				if(lndelyn.equals("Y")) {
					//공지사항 알림 
					String pname= (String)session.getAttribute("pname");
					int cnt = ns.alarmNoticeInsert(lidx, lnidx, pname);					
				}
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNoticeWrite.do";
			}
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/lecNotModify.do")
	public String lecNoticeModify(@RequestParam("lnidx") int lnidx, HttpSession session, Model model) {
		//공지사항 수정 화면
		int pidx = (Integer)session.getAttribute("pidx");
		//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		return "lecture/noticeModify";
	}
	
	@RequestMapping(value="/lecNotModifyAction.do")
	public String lecNoticeModifyAction(@RequestParam("lecNotSubject") String lnsubject,
									@RequestParam("lecNotContents") String lncontents,
									@RequestParam("lecNotFile") MultipartFile lnfile,
									@RequestParam("lnidx") int lnidx,
									HttpSession session) throws Exception {
		//공지사항 수정 완료
		String str = null;
		
		if(lnfile.isEmpty()) { // 첨부파일 없는 경우 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lnidx", lnidx);
			
			int value = lns.lecNotModify(hm);
			
			if(value == 1) { //수정 완료
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNotModify.do?lnidx="+lnidx;
			}
			
		} else { //첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = lnfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			//저장된 이름
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, lnfile.getBytes());
			
			HashMap<String, Object> lecNoticeFile = new HashMap<String, Object>();
			lecNoticeFile.put("originName", originalFileName);
			lecNoticeFile.put("savedName", savedName);
			lecNoticeFile.put("originalFileExtension", originalFileExtension);
			lecNoticeFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lnidx", lnidx);
			
			int value = lns.lecNotAndFileModify(hm, lecNoticeFile);
			
			if(value == 2) { //수정 완료
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNotModify.do?lnidx="+lnidx;
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/lecNotDeleteAction.do")
	public String lecNoticeDelete(HttpSession session, RedirectAttributes rttr) {
		//공지사항 삭제
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		LecNoticeVO lnv = (LecNoticeVO)session.getAttribute("lnv");
		int lnidx = lnv.getLnidx();
		
		String str = "";
		
		int value = lns.lecNoticeDelete(lnidx);
		
		if(value==1) {
			//공지사항 삭제시 알림 삭제
			int cnt=ns.alarmNoticeDelete(lnidx);
			
			rttr.addFlashAttribute("msg", "삭제되었습니다.");
			str="redirect:/noticeList.do?lidx="+lidx;
		} else {
			str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
		}
		
		
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="/lnExFileDelete.do")
	public HashMap<String,Object> lnExFileDelete(@RequestParam("fidx") int fidx,
										@RequestParam("lnidx") int lnidx) {
		//수정페이지에서 파일 삭제버튼 눌렀을 때(ajax)
		int value = lns.lnExFileDelete(lnidx, fidx);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
