//211027 jhr 작업
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

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.StudentService;
import com.onclick.app.service.TaskService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class S_taskController {
	
	@Autowired
	TaskService ts;
	
	@Autowired
	S_taskService sts;
	
	@Autowired
	FileService fs;
	
	@Autowired
	StudentService ss;
	
	@Autowired
	LecService ls;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/stuTaskWrite.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session, Model model) {
		
		int sidx = (Integer)session.getAttribute("sidx");
		//강의 이름 가져오기(대시보드-강의목록)
		ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
		model.addAttribute("stuLecList", stuLecList);
		
		//학생 과제작성 화면
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "lecture/stuTaskWrite";
	}
	

	@RequestMapping(value="/stuTaskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") MultipartFile tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session) throws Exception{
		//학생 과제작성 실행
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		int tidx = sts.s_taskTidx(sidx, tuidx);
		
		String str ="";
		
		if(tfile.isEmpty()) {//첨부파일 없는 경우
		
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskUpdate(hm);
			
			if(value == 0) {
				str = "redirect:/stuTaskWrite.do?tuidx="+tuidx;
			} else {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			}
		} else { //첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = tfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tfile.getBytes());
			
			HashMap<String, Object> stuTaskFile = new HashMap<String, Object>();
			stuTaskFile.put("originName", originalFileName);
			stuTaskFile.put("savedName", savedName);
			stuTaskFile.put("originalFileExtension", originalFileExtension);
			stuTaskFile.put("route", route);
			
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskAndFileUpdate(hm, stuTaskFile);
			
			if(value == 2) {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			} else {
				str = "redirect:/stuTaskWrite.do?tuidx="+tuidx;
			}
		}
		
		
		return str;
	}
	
	
	@RequestMapping(value="/stuTaskContent.do")
	public String taskContents(@RequestParam("tidx") int tidx,
							HttpSession session, Model model) {
		
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
		
		//학생 제출한 과제내용 보기
		S_taskDTO std = sts.s_taskSelectOne(tidx);
		session.setAttribute("std", std);
		//교수님 과제 정보 세션에 담기
		TaskVO tv = ts.taskSelectOne(std.getTuidx());
		session.setAttribute("tv", tv);
		//첨부파일 가져오기
		if((Integer)std.getFidx() != null) {
			FileVO fv = fs.fileSelectAll(std.getFidx());
			session.setAttribute("fv", fv);
		}
		return "lecture/stuTaskContent";
	}
	
	
	@RequestMapping(value="/stuTaskModify.do")
	public String taskUpdate(HttpSession session, Model model) {
		//학생 과제수정 화면
		int sidx = (Integer)session.getAttribute("sidx");
		//강의 이름 가져오기(대시보드-강의목록)
		ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
		model.addAttribute("stuLecList", stuLecList);
		
		return "lecture/stuTaskModify";
	}
	
	
	@RequestMapping(value="/stuTaskModifyAction.do")
	public String taskUpdateAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") MultipartFile tfile,
								@RequestParam("s_taskContents") String tcontents,
								@RequestParam("tidx") int tidx,
								HttpSession session) throws Exception {
		int sidx = (Integer)session.getAttribute("sidx");
		
		String str ="";
		
		if(tfile.isEmpty()) {//첨부파일 수정 X
		
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskModify(hm);
			
			if(value == 1) {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			} else {
				str ="redirect:/stuTaskModify.do?tidx="+tidx;
			}
		} else { //첨부파일 수정 O
			
			//첨부파일 저장
			//파일명
			String originalFileName = tfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tfile.getBytes());
			
			HashMap<String, Object> stuTaskFile = new HashMap<String, Object>();
			stuTaskFile.put("originName", originalFileName);
			stuTaskFile.put("savedName", savedName);
			stuTaskFile.put("originalFileExtension", originalFileExtension);
			stuTaskFile.put("route", route);
			
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskAndFileModify(hm, stuTaskFile);
			
			if(value == 2) {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			} else {
				str = "redirect:/stuTaskModify.do?tidx="+tidx;
			}
		}
		
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/stuExFileDelete.do")
	public HashMap<String,Object> fileDelete(@RequestParam("fidx") int fidx,
							@RequestParam("tidx") int tidx) {
		//수정페이지에서 파일 삭제 -ajax이용
		int value = sts.stuExFileDelete(tidx, fidx);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
