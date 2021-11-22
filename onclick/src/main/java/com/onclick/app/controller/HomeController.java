package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.TaskService;

@Controller
public class HomeController {

	@Autowired
	LecService ls;
	
	@Autowired
	LecNoticeService lns;
	
	@Autowired
	TaskService ts;
	
	@RequestMapping(value="/")
	public String main() {
		//Main 페이지 전환
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//학생,교수 회원 가입 화면
		return "join";
	}
	
	@RequestMapping(value="/siteMap.do")
	public String siteMap() {
		//사이트맵 이동
		return "siteMap";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model, HttpSession session) {

		//대시보드 강의 목록에서 강의 메인 홈으로 넘어가기
		LecVO lv = ls.lecHome(lidx);
		session.setAttribute("lv", lv);
		
		ArrayList<LecNoticeVO> lndList = lns.lecNoticeSelectDash(lidx);
		model.addAttribute("lndList", lndList);
		
		ArrayList<TaskVO> tlist = ts.taskDashSelectAll(lidx);
		model.addAttribute("tlist", tlist);
		
		return "lecture/home";
	}
	
	@RequestMapping(value="/stuList.do")
	public String lecStudentList(@RequestParam("lidx") int lidx, Model model) {
		//강의 - 학생 목록 
		ArrayList<StudentVO> alist = ls.lecStudentList(lidx);
		model.addAttribute("alist", alist);
		
		return "lecture/stuList";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
    public String professorLogout(RedirectAttributes rttr,
    								   HttpSession session) throws Exception{
		//공통화면 로그아웃
		
		 //세션에 저장된 값을 삭제
		 session.invalidate();
		 
		 rttr.addFlashAttribute("logout", "로그아웃 하였습니다.");

		return "redirect:/";
	}


}
