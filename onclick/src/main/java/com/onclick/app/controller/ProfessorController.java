package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.ProfessorVO;
import com.onclick.app.service.LecService;
import com.onclick.app.service.ProfessorService;
import com.onclick.app.service.StudentService;

@Controller
public class ProfessorController { 

	@Autowired
	ProfessorService ps;
	
	@Autowired
	LecService ls;
	
	@Autowired
	StudentService ss;
	
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
		
		return "redirect:/";
	}

	@RequestMapping(value="/professor/proLogin.do")
	public String professorLogin(@RequestParam("pidx") int pidx,
								 @RequestParam("ppwd") String ppwd,
								 RedirectAttributes rttr,
								 HttpSession session) {
		//교수 로그인 
		ProfessorVO pv = ps.professorLogin(pidx, ppwd);
		
		String location = "";
		if(pv != null) {
			//login 성공시 

			//사번 저장 
			session.setAttribute("pidx", pidx);
			session.setAttribute("pname",pv.getPname());
			
			location ="redirect:/professor/proDashBoard.do";	
		}else {
			//login 실패시 
			rttr.addFlashAttribute("loginNok", "로그인 실패하셨습니다");
			location ="redirect:/";
		}
		return location;
	}
	
	@RequestMapping(value="/professor/proDashBoard.do")
	public String professorLecList(HttpSession session, Model model) {
		//대시보드 이동
		
		int pidx = (Integer)session.getAttribute("pidx");
		
		//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);
		
		return "/professor/proDashBoard" ;
	}
	@RequestMapping(value="/professor/pwdCheck.do")
	public String professorpwdCheck(HttpSession session, Model model) {
		//학생 정보수정 - 비밀번호 확인 페이지
		int pidx = (Integer)session.getAttribute("pidx");
		
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);
		
		return "/professor/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/professor/pwdCheckAction.do")
	public int professorPwdCheckAction(@RequestParam("pwd") String ppwd) {
		//교수 정보수정 - 비밀번호 확인 실행 ajax
		int cnt = ps.proPwdCheck(ppwd);
		
		return cnt;
	}
	
	@RequestMapping(value="/professor/proModifyAction.do")
	public String professorModifyAction(@RequestParam("ppwd") String ppwd,
									  @RequestParam("pemail1") String pemail1,
									  @RequestParam("pemail2") String pemail2,
									  @RequestParam("pphone1") String pphone1,
									  @RequestParam("pphone2") String pphone2,
									  @RequestParam("pphone3") String pphone3
									) {
		//교수 정보 수정실행
		String pemail = pemail1+"@"+pemail2;
		String pphone = pphone1 + "-" + pphone2 + "-" +pphone3;
		
		return "redirect:/professor/pwdCheck.do";
	}
	

	@RequestMapping(value="/professor/proInfo.do")
	public String professorInfo(@RequestParam("pidx") int pidx, Model model, HttpSession session) {
		//교수정보 보기
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//강의 이름 가져오기
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);

		return "professor/proInfo";
	}
		
	@RequestMapping(value="/professor/proModify.do")
	public String professorModify(HttpSession session, Model model) {
		//교수 정보 수정 화면
		int pidx = (Integer)session.getAttribute("pidx");
		
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);
		
		return "professor/proModify";
	}
	
/*	
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
