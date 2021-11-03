package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.service.ProfessorService;

@Controller
public class ProfessorController { 

	@Autowired
	ProfessorService ps;
	
	@ResponseBody
	@RequestMapping(value="/professor/idCheck.do")
	public int professorIdCheck(@RequestParam("pidx") String pidx) {
		//교수 사번 중복체크 - ajax 이용
		int cnt = ps.professorIdCheck(pidx);

		return cnt;
	}
	
	@RequestMapping(value="/professor/joinAction.do")
	public String professorJoinAction(@RequestParam("pidx") int pidx,
									@RequestParam("pname") String pname,
									@RequestParam("ppwd") String ppwd,
									@RequestParam("pphone") int pphone,
									@RequestParam("pemail") String pemail) {
		//교수 회원가입 완료
		int cnt = ps.professorJoin(pidx, pname, ppwd, pphone, pemail);
		
		return "mypage";
	}
/*	
	@RequestMapping(value="*.do")
	public String professorLogin() {
		//교수 로그인
		return "";
	}
		
	@RequestMapping(value="*.do")
	public String professorModify() {
		//교수 정보 수정 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorModifyAction() {
		//교수 정보 수정 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLogout() {
		//교수 로그아웃
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecList() {
		//교수 강의 목록
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecPlan() {
		//강의계획서
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorIdCheck() {
		//사번 체크
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwd() {
		//교수 비밀번호 찾기 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwdAction() {
		//교수 비밀번호 찾기 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorContents() {
		//교수 정보 보기
		return "";
	}
	*/
}
