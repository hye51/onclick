package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	//@Autowired
	//SqlSession sqlSession;
	
	//@Autowired(required = false)
	//DriverManagerDataSource db;
	
	@RequestMapping(value="/")
	public String main() {
		//Main 페이지 전환
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//학생,교수 회원 가입 화면
		//System.out.println("sqlsession :" + sqlSession );
		//System.out.println("db  : " + db );
		return "join";
	}
	
/*	
	
	@RequestMapping(value = "/pwdCheck.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "student/pwdCheck";
	}
	
	@RequestMapping(value = "/studentModify.do", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {

		return "student/stuModify";
	}
	
	@RequestMapping(value = "/lecture/home.do", method = RequestMethod.GET)
	public String home3(Locale locale, Model model) {

		return "/lecture/home";
	}
	
	@RequestMapping(value = "/lecture/noticeList.do", method = RequestMethod.GET)
	public String home4(Locale locale, Model model) {

		return "/lecture/noticeList";
	}
	

	@RequestMapping(value = "/lecture/proInfo.do", method = RequestMethod.GET)
	public String hom5(Locale locale, Model model) {

		return "/lecture/proInfo";
	}
	*/
}
