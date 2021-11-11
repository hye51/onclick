//211027 jhr 작업
package com.onclick.app.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.TaskService;

@Controller
public class S_taskController {
	
	@Autowired
	TaskService ts;
	
	@Autowired
	S_taskService sts;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/taskSubmit.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session) {
		//학생 과제작성 화면
		TaskVO tv = ts.taskContent(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "lecture/stuTaskWrite";
	}
	

	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") MultipartFile tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session, Model model) throws Exception{
		//첨부파일 저장
		//파일명
		String originalFileName = tfile.getOriginalFilename();
		System.out.println(originalFileName);
		//파일명 중 확장자만 추출
		String orignalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		//파일경로
		String route = uploadPath;
		//파일 저장
		if(!tfile.getOriginalFilename().isEmpty()) {
			tfile.transferTo(new File(uploadPath, originalFileName));
		} else {
			model.addAttribute("msg", "파일 업로드를 완료하지 못했습니다.");
		}
		
		//학생 과제작성 실행
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", originalFileName);
		hm.put("sidx", sidx);
		hm.put("tuidx", tuidx);
		
		int value = sts.s_taskInsert(hm);
		
		return "lecture/stuTaskSubmit";
	}
	
		/*
	@RequestMapping(value="/.do")
	public String taskDelete() {
		//학생 과제삭제
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String task() {
		//학생 과제작성 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdate() {
		//학생 과제수정 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdateAction() {
		//학생 과제수정  실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskContents() {
		//학생 과제내용 보기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskList() {
		//학생 과제 리스트보기
		return null;
	}
	*/
}
