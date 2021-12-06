//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.VideoDTO;
import com.onclick.app.service.AttendenceService;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.StudentService;

@Controller
public class AttendenceController {

	@Autowired
	LecService ls;
	
	@Autowired
	StudentService ss;
	
	@Autowired
	AttendenceService as;
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/stuVideoAttend.do")
	public String vAttenStudent(@RequestParam("lidx") int lidx,
							HttpSession session, Model model) {
		//�л� ���� �⼮Ȯ�� ȭ��(������)
		int sidx = (Integer)session.getAttribute("sidx");
		//���� �̸� ��������(��ú���-���Ǹ��)
		ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
		model.addAttribute("stuLecList", stuLecList);
		//������ �⼮
		ArrayList<VideoDTO> vlist = as.stuVideoAttend(lidx, sidx);
		model.addAttribute("vlist", vlist);
		
		return "student/stuVideoAttend";
	}
	
	
	@RequestMapping(value="/proVideoAttend.do")
	public String vAttenProList(@RequestParam("lidx") int lidx,
								@RequestParam("cweek") int cweek,
								HttpSession session, Model model) {
		
		int pidx = (Integer)session.getAttribute("pidx");
		//���� ������� ���� ���̺��� ���� ��� �������� 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		//���� �л� ��ü �⼮Ȯ�� ȭ��(������)
		if(cweek == 0) { cweek = 1;	}
		
		ArrayList<ClassVo> clist = cs.classWeekVideo(lidx, cweek);
		
		String cidx = "0"; 
		int ci = 0;
		
		for(int i=0; i<clist.size();i++) {
			ci = clist.get(i).getCidx();
			if (clist.size() ==3) //������ ���� 3��
				cidx = ci+","+cidx;           // 3,2,1,0
			 else if (clist.size() ==2) //������ ���� 2��	
				cidx =  ci +","+cidx;    //  2,1,0
			 else if (clist.size() ==1) //������ ���� 1��
				cidx =  ci +",0,0";
			 else if(clist.size() ==0) //������ ���� ����
			 	cidx = "0,0,0";
			
		}
//		System.out.println("cidx"+cidx);
	
		String[] str = cidx.split(",");
//		System.out.println("�迭"+str[0]);
		
		ArrayList<VideoDTO> vlist = null;
		
		if(clist.size() ==3) {
			vlist = as.proVideoAttend(Integer.parseInt(str[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
		} else if(clist.size() ==2) {
			vlist = as.proVideoAttend(Integer.parseInt(str[1]),Integer.parseInt(str[0]),Integer.parseInt(str[2]));
		} else {
			vlist = as.proVideoAttend(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		}
		
		model.addAttribute("vlist", vlist);
		model.addAttribute("clist", clist);
		
		return "professor/proVideoAttend";
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
