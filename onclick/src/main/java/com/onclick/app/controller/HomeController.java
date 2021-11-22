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
		//Main ������ ��ȯ
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//�л�,���� ȸ�� ���� ȭ��
		return "join";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model, HttpSession session) {

		//��ú��� ���� ��Ͽ��� ���� ���� Ȩ���� �Ѿ��
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
		//���� - �л� ��� 
		ArrayList<StudentVO> alist = ls.lecStudentList(lidx);
		model.addAttribute("alist", alist);
		
		return "lecture/stuList";
	}

	@ResponseBody
	@RequestMapping(value="/alarmUpdate.do")
	public int alarmUpdate(@RequestParam("nidx") int nidx) {
		//�˸� ����ǥ�� 
		System.out.println("nidx : " + nidx);
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
}
