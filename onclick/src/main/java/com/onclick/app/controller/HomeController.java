package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.NoticeVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.NoticeService;
import com.onclick.app.service.TaskService;

@Controller
public class HomeController {

	@Autowired
	LecService ls;
	
	@Autowired
	LecNoticeService lns;
	
	@Autowired
	TaskService ts;
	
	@Autowired
	NoticeService ns;
	
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

	@ResponseBody
	@RequestMapping(value="/alarmUpdate.do")
	public int alarmUpdate(@RequestParam("nidx") int nidx) {
		//알림 읽음표시 
		System.out.println("nidx : " + nidx);
		int cnt=ns.alarmUpdate(nidx);
		
		return cnt;
	}

	@ResponseBody
	@RequestMapping(value="/alarmSelect.do")
	public ArrayList<NoticeVO> alarmSelect(@RequestParam("sidx") int sidx) {
		//알림 조회
		ArrayList<NoticeVO> data = ns.alarmList(sidx);

		return data;
	}
}
