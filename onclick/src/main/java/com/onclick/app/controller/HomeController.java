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
		//Main ������ ��ȯ
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//�л�,���� ȸ�� ���� ȭ��
		return "join";
	}
	
	@RequestMapping(value="/find.do")
	public String find() {
		//�л�,���� ID/PW ã�� ȭ��
		return "find";
	}
	
	@RequestMapping(value="/siteMap.do")
	public String siteMap() {
		//�л�,���� ID/PW ã�� ȭ��
		return "siteMap";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//���� �̸� ��������
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//���� ������� ���� ���̺��� ���� ��� �������� 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		//��ú��� ���� ��Ͽ��� ���� ���� Ȩ���� �Ѿ��
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
			//���� �̸� ��������
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//���� ������� ���� ���̺��� ���� ��� �������� 
			ArrayList<LecVO> alist2 = ls.lecSelectAll(pidx);
			model.addAttribute("alist2", alist2);
		}
		
		//���� - �л� ��� 
		ArrayList<StudentVO> alist = ls.lecStudentList(lidx);
		model.addAttribute("alist", alist);
		
		return "lecture/stuList";
	}

	@ResponseBody
	@RequestMapping(value="/alarmUpdate.do")
	public int alarmUpdate(@RequestParam("nidx") int nidx) {
		//�˸� ����ǥ�� 
		int cnt=ns.alarmUpdate(nidx);
		return cnt;
	}

	@ResponseBody
	@RequestMapping(value="/alarmSelect.do")
	public ArrayList<NoticeVO> alarmSelect(@RequestParam("sidx") int sidx) {
		//�˸� ��ȸ
		ArrayList<NoticeVO> data = ns.alarmList(sidx);
		return data;
	}
	

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String professorLogout(RedirectAttributes rttr,  HttpSession session) throws Exception{
			//����ȭ�� �α׾ƿ�
			
			 //���ǿ� ����� ���� ����
			 session.invalidate();
			 
			 rttr.addFlashAttribute("logout", "�α׾ƿ� �Ͽ����ϴ�.");

			return "redirect:/";
	}
	
	
}
