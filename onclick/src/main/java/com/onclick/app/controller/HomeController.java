package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.NoticeVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.NoticeService;
import com.onclick.app.service.StudentService;
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

	@Autowired
	ClassService cs;
	
	@Autowired
	StudentService ss;
	
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
	
	@RequestMapping(value="/find.do")
	public String find() {
		//학생,교수 ID/PW 찾기 화면
		return "find";
	}
	
	@RequestMapping(value="/siteMap.do")
	public String siteMap() {
		//학생,교수 ID/PW 찾기 화면
		return "siteMap";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//강의 이름 가져오기
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		//대시보드 강의 목록에서 강의 메인 홈으로 넘어가기
		LecVO lv = ls.lecHome(lidx);
		session.setAttribute("lv", lv);
		
		ArrayList<LecNoticeVO> lndList = lns.lecNoticeSelectDash(lidx);
		model.addAttribute("lndList", lndList);
		
		ArrayList<TaskVO> tlist = ts.taskDashSelectAll(lidx);
		model.addAttribute("tlist", tlist);
		
		ArrayList<ClassVo> cdList = cs.classFinDash(lidx);
		model.addAttribute("cdList", cdList);
		
		return "lecture/home";
	}
	
	@RequestMapping(value="/stuList.do")
	public String lecStudentList(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//강의 이름 가져오기
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
			ArrayList<LecVO> alist2 = ls.lecSelectAll(pidx);
			model.addAttribute("alist2", alist2);
		}
		
		//강의 - 학생 목록 
		ArrayList<StudentVO> alist = ls.lecStudentList(lidx);
		model.addAttribute("alist", alist);
		
		return "lecture/stuList";
	}

	@ResponseBody
	@RequestMapping(value="/alarmUpdate.do")
	public int alarmUpdate(@RequestParam("nidx") int nidx) {
		//알림 읽음표시 
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
	

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String professorLogout(RedirectAttributes rttr,  HttpSession session) throws Exception{
			//공통화면 로그아웃
			
			 //세션에 저장된 값을 삭제
			 session.invalidate();
			 
			 rttr.addFlashAttribute("logout", "로그아웃 하였습니다.");

			return "redirect:/";
	}
	
	
}
