package com.onclick.app.controller;

import java.util.ArrayList;

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

		@RequestMapping(value="/student/taskContent.do")
		public String taskContent(@RequestParam("tuidx") int tuidx, 
								@RequestParam("lidx") int lidx, Model model, HttpSession session) {
			
			//대시보드 과제 목록에서 과제 내용보기로 넘어가기
			TaskVO tv = ts.taskContent(tuidx);
			model.addAttribute("tv", tv);
			//해당 과목 정보 가져오기
			LecVO lv = ls.lecSelectOne(lidx);
			session.setAttribute("lv", lv);
			
			return "/student/taskContent";
		}

		@RequestMapping(value="/taskList.do")
		public String taskList(@RequestParam("lidx") int lidx, Model model) {
			//교수 과제 목록
			ArrayList<TaskVO> tlist = ts.taskSelectAll(lidx);
			model.addAttribute("tlist", tlist);
			
			return "student/taskList";
		}
		
/*
	@RequestMapping(value="*.do")
	public String taskWrite() {
		//교수 과제 작성 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskWriteAction() {
		//교수 과제 작성 완료
		return "";
	}
		
	@RequestMapping(value="*.do")
	public String taskContents() {
		//과제 내용보기
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModify() {
		//교수 과제 수정 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModifyAction() {
		//교수 과제 수정 완료
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
