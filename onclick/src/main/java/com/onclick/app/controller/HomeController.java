package com.onclick.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;

@Controller
public class HomeController {

	@Autowired
	LecService ls;
	
	@Autowired
	LecNoticeService lns;
	
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
	public String LecHome(@RequestParam("lidx") int lidx, Model model) {
		
		//대시보드 강의 목록에서 강의 메인 홈으로 넘어가기
		LecVO lv = ls.lecHome(lidx);
		model.addAttribute("lv", lv);
		
		ArrayList<LecNoticeVO> lndList = lns.lecNoticeSelectDash(lidx);
		model.addAttribute("lndList", lndList);
		
		return "lecture/home";
	}
	
	

}
