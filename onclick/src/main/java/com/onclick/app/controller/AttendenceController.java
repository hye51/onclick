//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.VideoDTO;
import com.onclick.app.service.AttendenceService;
import com.onclick.app.service.ClassService;

@Controller
public class AttendenceController {

	@Autowired
	AttendenceService as;
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/stuVideoAttend.do")
	public String vAttenStudent(@RequestParam("lidx") int lidx,
							HttpSession session, Model model) {
		//�л� ���� �⼮Ȯ�� ȭ��(������)
		int sidx = (Integer)session.getAttribute("sidx");
		//������ �⼮
		ArrayList<VideoDTO> vlist = as.stuVideoAttend(lidx, sidx);
		
		model.addAttribute("vlist", vlist);
		
		return "student/stuVideoAttend";
	}
	
	@RequestMapping(value="/stuLiveAttend.do")
	public String lAttenStudent(@RequestParam("lidx") int lidx,
							HttpSession session, Model model) {
		//�л� ���� �⼮Ȯ�� ȭ��(�ǽð�)
		int sidx = (Integer)session.getAttribute("sidx");
		//�ǽð� �⼮
		ArrayList<AttendenceDTO> alist = as.stuLiveAttend(lidx, sidx);
		
		model.addAttribute("alist", alist);
		
		return "student/stuLiveAttend";
	}
	
	@RequestMapping(value="/proVideoAttend.do")
	public String vAttenProList(@RequestParam("lidx") int lidx,
								@RequestParam("cweek") int cweek,
								Model model) {
		//���� �л� ��ü �⼮Ȯ�� ȭ��(������)
		if(cweek == 0) { cweek = 1;	}
		ArrayList<VideoDTO> vlist = as.proVideoAttend(lidx, cweek);
		
		ArrayList<ClassVo> clist = cs.classWeekVideo(lidx, cweek);
		
		model.addAttribute("vlist", vlist);
		model.addAttribute("clist", clist);
		
		return "professor/proVideoAttend";
	}
	
	@RequestMapping(value="/proLiveAttend.do")
	public String lAttenProList(@RequestParam("lidx") int lidx) {
		//���� �л� ��ü �⼮Ȯ�� ȭ��(�ǽð�)
		
		return "professor/proLiveAttend";
	}
/*	
	@RequestMapping(value="/.do")
	public String attenProUpdate() {
		//���� ��ü�л��� ���� �⼮���� ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String attenProUpdateAction() {
		//���� ��ü�л��� ���� �⼮���� �Ϸ�
		return null;
	}
	*/
}
