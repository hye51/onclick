 package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.LecService;
import com.onclick.app.service.TaskService;

@Controller
public class TaskController { //교수 과제 컨트롤러

	@Autowired
	TaskService ts;
	
	@Autowired
	LecService ls;

	@RequestMapping(value="/taskContent.do")
	public String taskContent(@RequestParam("tuidx") int tuidx, 
							@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		
		//대시보드 과제 목록에서 과제 내용보기로 넘어가기
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		//해당 과목 정보 가져오기
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		
		return "lecture/taskContent";
	}

	@RequestMapping(value="/taskList.do")
	public String taskList(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		//교수 과제 목록
		ArrayList<TaskVO> tlist = ts.taskSelectAll(lidx);
		model.addAttribute("tlist", tlist);
		//해당 과목 정보 가져오기
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		
		return "lecture/taskList";
	}
	
		
	@RequestMapping(value="/taskWrite.do")
	public String taskWrite() {
		//교수 과제 작성 화면
		
		return "lecture/taskUpload";
	}
	
	
	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("lidx") int lidx,
								@RequestParam("taskSubject") String tusubject,
								@RequestParam("taskStart") String tustart,
								@RequestParam("taskFin") String tufin,
								@RequestParam("taskContents") String tucontents,
								@RequestParam("taskFile") String tufile) {
		//교수 과제 작성 완료
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("tusubject", tusubject);
		hm.put("tustart", tustart);
		hm.put("tufin", tufin);
		hm.put("tufile", tufile);
		hm.put("lidx", lidx);
		hm.put("tucontents", tucontents);
		
		String str = null;
		int value = ts.taskInsert(hm);
		
		if(value == 0) {
			str="redirect:/taskWrite.do?lidx="+lidx;
		} else {
			str="redirect:/taskContent.do?lidx="+lidx;
		}
		
		return "";
	}
	
	
	@RequestMapping(value="/taskModify.do")
	public String taskModify(@RequestParam("tuidx") int tuidx,
							HttpSession session) {
		//교수 과제 수정 화면
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		
		return "lecture/taskModify";
	}
	
	
	@RequestMapping(value="/taskModifyAction.do")
	public String taskModifyAction() {
		//교수 과제 수정 완료
		return "";
	}
	

	
	
	
/*		
	@RequestMapping(value="*.do")
	public String taskContents() {
		//과제 내용보기
		return "";
	}
	
	
	@RequestMapping(value="*.do")
	public String taskDelete() {
		//교수 과제 삭제 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskSubmitList() {
		//학생 과제 제출 목록
		return "";
	}
	*/
}
