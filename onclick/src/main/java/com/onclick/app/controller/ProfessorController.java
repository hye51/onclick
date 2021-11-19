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

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.ProfessorVO;
import com.onclick.app.service.LecService;
import com.onclick.app.service.ProfessorService;

@Controller
public class ProfessorController { 

	@Autowired
	ProfessorService ps;
	
	@Autowired
	LecService ls;
	
	@ResponseBody
	@RequestMapping(value="/professor/idCheck.do")
	public int professorIdCheck(@RequestParam("pidx") String pidx) {
		//���� ��� �ߺ�üũ - ajax �̿�
		int cnt = ps.professorIdCheck(pidx);

		return cnt;
	}
	
	@RequestMapping(value="/professor/joinAction.do")
	public String professorJoinAction(@RequestParam("pidx") int pidx,
									@RequestParam("pname") String pname,
									@RequestParam("ppwd") String ppwd,
									@RequestParam("pphone") int pphone,
									@RequestParam("pemail") String pemail) {
		//���� ȸ������ �Ϸ�
		int cnt = ps.professorJoin(pidx, pname, ppwd, pphone, pemail);
		
		return "redirect:/";
	}

	@RequestMapping(value="/professor/proLogin.do")
	public String professorLogin(@RequestParam("pidx") int pidx,
								 @RequestParam("ppwd") String ppwd,
								 RedirectAttributes rttr,
								 HttpSession session) {
		//���� �α��� 
		ProfessorVO pv = ps.professorLogin(pidx, ppwd);
		
		String location = "";
		if(pv != null) {
			//login ������ 

			//��� ���� 
			session.setAttribute("pidx", pidx);
			session.setAttribute("pname",pv.getPname());
			
			location ="redirect:/professor/proDashBoard.do";	
		}else {
			//login ���н� 
			rttr.addFlashAttribute("loginNok", "�α��� �����ϼ̽��ϴ�");
			location ="redirect:/";
		}
		return location;
	}
	
	@RequestMapping(value="/professor/proDashBoard.do")
	public String professorLecList(HttpSession session, Model model) {
		//��ú��� �̵�
		
		int pidx = (Integer)session.getAttribute("pidx");
		
		//���� ������� ���� ���̺��� ���� ��� �������� 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);

		return "/professor/proDashBoard" ;
	}
	@RequestMapping(value="/professor/pwdCheck.do")
	public String professorpwdCheck() {
		//�л� �������� - ��й�ȣ Ȯ�� ������
		return "/professor/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/professor/pwdCheckAction.do")
	public int professorPwdCheckAction(@RequestParam("pwd") String ppwd) {
		//���� �������� - ��й�ȣ Ȯ�� ���� ajax
		int cnt = ps.proPwdCheck(ppwd);
		
		return cnt;
	}
	

	@RequestMapping(value="/professor/proInfo.do")
	public String professorInfo(@RequestParam("pidx") int pidx, Model model, HttpSession session) {
		//�������� ����
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);

		return "professor/proInfo";
	}
/*		
	@RequestMapping(value="*.do")
	public String professorModify() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorModifyAction() {
		//���� ���� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLogout() {
		//���� �α׾ƿ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecList() {
		//���� ���� ���
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecPlan() {
		//���ǰ�ȹ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorIdCheck() {
		//��� üũ
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwd() {
		//���� ��й�ȣ ã�� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwdAction() {
		//���� ��й�ȣ ã�� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorContents() {
		//���� ���� ����
		return "";
	}
	*/
}
