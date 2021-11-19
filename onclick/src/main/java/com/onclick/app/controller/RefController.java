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

import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.RefVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.RefService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class RefController { //자료 컨트롤러
	
	@Autowired
	RefService rs;
	
	@Autowired
	FileService fs;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/refWrite.do")
	public String refWrite() {
		//자료 작성 화면
		return "lecture/refUpload";
	}
	
	
	@RequestMapping(value="/refWriteAction.do")
	public String refWriteAction(@RequestParam("lidx") int lidx,
								@RequestParam("refSubject") String rname,
								@RequestParam("refContents") String rcontents,
								@RequestParam("refFile") MultipartFile rfile) throws Exception {
		//자료 작성 완료
		String str = null;
		
		if(rfile.isEmpty()) { // 첨부파일 없는 경우 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("lidx", lidx);
			hm.put("fidx", "");
			
			int value = rs.refInsert(hm);
			//insert된 강의 공지사항 인덱스 받아오기
			int ridx = Integer.parseInt(String.valueOf(hm.get("ridx")));
			
			if(value == 1) { //insert 성공
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refWrite.do";
			}
			
		} else { //첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = rfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			//저장된 이름
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, rfile.getBytes());
			
			HashMap<String, Object> refFile = new HashMap<String, Object>();
			refFile.put("originName", originalFileName);
			refFile.put("savedName", savedName);
			refFile.put("originalFileExtension", originalFileExtension);
			refFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("lidx", lidx);
			
			int value = rs.refAndFileInsert(hm, refFile);
			//insert된 강의 공지사항 인덱스 받아오기
			int ridx = Integer.parseInt(String.valueOf(hm.get("ridx")));
			
			if(value == 2) { //insert 성공
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refWrite.do";
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/refList.do")
	public String refList(@RequestParam("lidx") int lidx, Model model) {
		//자료 목록
		ArrayList<RefVO> rlist = rs.refSelectAll(lidx);
		model.addAttribute("rlist", rlist);
		
		return "lecture/refList";
	}
	
	
	@RequestMapping(value="/refContent.do")
	public String refContents(@RequestParam("ridx") int ridx, HttpSession session) {
		//자료 내용보기
		RefVO rv = rs.refSelectOne(ridx);
		session.setAttribute("rv", rv);
		
		//파일 인덱스 있는 경우 FileVO 세션에 담기
		if((Integer)rv.getFidx() != null) {
			FileVO fv = fs.fileSelectAll(rv.getFidx());
			session.setAttribute("fv", fv);
		}
		return "lecture/refContent";
	}
	
	
	@RequestMapping(value="/refModify.do")
	public String refModify(@RequestParam("ridx") int ridx, HttpSession session) {
		//자료 수정 화면
		RefVO rv = rs.refSelectOne(ridx);
		session.setAttribute("rv", rv);
		
		return "lecture/refModify";
	}
	
	
	@RequestMapping(value="/refModifyAction.do")
	public String refModifyAction(@RequestParam("ridx") int ridx,
			@RequestParam("refSubject") String rname,
			@RequestParam("refContents") String rcontents,
			@RequestParam("refFile") MultipartFile rfile) throws Exception {
		//자료 수정 완료
		String str = null;
		
		if(rfile.isEmpty()) { // 첨부파일 수정 X 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("ridx", ridx);
			
			int value = rs.refModify(hm);
			
			if(value == 1) { //insert 성공
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refModify.do?ridx="+ridx;
			}
			
		} else { //첨부파일 수정 O
			
			//새로운 첨부파일 저장
			//파일명
			String originalFileName = rfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			//저장된 이름
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, rfile.getBytes());
			
			HashMap<String, Object> refFile = new HashMap<String, Object>();
			refFile.put("originName", originalFileName);
			refFile.put("savedName", savedName);
			refFile.put("originalFileExtension", originalFileExtension);
			refFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("ridx", ridx);
			
			int value = rs.refAndFileModify(hm, refFile);
			
			if(value == 2) { //insert 성공
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refModify.do?ridx="+ridx;
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/refDeleteAction.do")
	public String refDelete(HttpSession session, RedirectAttributes rttr) {
		//자료 삭제 
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		RefVO rv = (RefVO)session.getAttribute("rv");
		int ridx = rv.getRidx(); 		
				
		int value = rs.refDelete(ridx);
		
		String str = null;				
				
		if(value == 1) {
			rttr.addFlashAttribute("msg", "삭제되었습니다.");
			str="redirect:/refList.do?lidx="+lidx;
		} else {
			str="redirect:/refContent.do?ridx="+ridx;
		}
		
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/rExFileDelete.do")
	public HashMap<String,Object> rExFileDelete(@RequestParam("fidx") int fidx,
										@RequestParam("ridx") int ridx) {
		//수정페이지에서 파일 삭제버튼 눌렀을 때(ajax)
		int value = rs.rExFileDelete(ridx, fidx);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
