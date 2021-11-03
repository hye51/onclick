//211027 jhr 작업
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService ss;
	
	@ResponseBody
	@RequestMapping(value="/student/idCheck.do")
	public int studentIdCheck(@RequestParam("sidx") String sidx) {
		//학생 학번 중복체크 - ajax 이용
		int cnt = ss.studentIdChcek(sidx);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/joinAction.do")
	public String studentJoinAction(@RequestParam("sidx") int sidx, 
									@RequestParam("spwd") String spwd,
									@RequestParam("sname") String sname,
									@RequestParam("sphone") int sphone,
									@RequestParam("semail") String semail) {
		//학생 회원 가입 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);

		return "redirect:/";
	}
	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								Model model) {
		//학생 로그인 후 대시보드 이동
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		
		if(sv != null) { 
			//로그인 성공 시
			//강의 이름 가져오기(대시보드-강의목록)
			System.out.println("로그인 성공");
			ArrayList<EnrollDTO> alist = ss.stuLecSelectAll(sidx);
			model.addAttribute("alist", alist);
			str = "/student/stuDashBoard";	
		} else {
			//로그인 실패 시 
			str = "redirect:/";
		}
		
		return str;
	}
	
/*	
	//학생  강의 홈 이동
	@RequestMapping(value="/student/lecHome.do")
	public String studentLecHome(@RequestParam("lidx") int lidx,
								 Model model) {
		
		//학생이 선택한 강의의 메인 홈으로 이동
		LecVO lv = ss.stuLecHome(lidx);
		model.addAttribute("lv", lv);
		
		return "/lecture/home";
	}

	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentModify() {
		//학생 정보 수정화면
		return "/student/pwdCheck";
	}
*/	
	/*
	@RequestMapijping(value="/.do")
	public String studentModifyAction() {
		//학생 정보 수정실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentLogout() {
		//학생 로그아웃
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentIdCheck() {
		//학생 회원가입시 학번확인
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentFindPwd() {
		//학생 비밀번호 찾기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeList() {
		//학생  알림화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeNonCheck() {
		//학생  알림 읽음 체크
		return null;
	}
	*/
	@RequestMapping(value="/lecture/stuList.do")
	public String enrollList() {
		//학생 수강신청 목록
		return "lecture/stuList";
	}
	
}
