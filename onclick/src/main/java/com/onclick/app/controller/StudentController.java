//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.service.StudentService;
import com.onclick.app.domain.TaskVO;

@Controller
public class StudentController {

	@Autowired
	StudentService ss;
	
	@ResponseBody
	@RequestMapping(value="/student/idCheck.do")
	public int studentIdCheck(@RequestParam("sidx") int sidx) {
		//�л� �й� �ߺ�üũ - ajax �̿�
		int cnt = ss.studentIdChcek(sidx);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/joinAction.do")
	public String studentJoinAction(@RequestParam("sidx") int sidx, 
									@RequestParam("spwd") String spwd,
									@RequestParam("sname") String sname,
									@RequestParam("sphone") String sphone,
									@RequestParam("semail") String semail,
									RedirectAttributes rttr ) {
		//�л� ȸ�� ���� 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);
		rttr.addFlashAttribute("joinOk", "ȸ�����Կ� �����Ͽ����ϴ�");
		
		return "redirect:/";
	}

	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								RedirectAttributes rttr, 
								HttpSession session) {
		//�л� �α��� �� ��ú��� �̵�
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		
		
		System.out.println("sv"+sv);
		
		//�й� ���ǿ� ���� ( ���ͼ��Ϳ��� ó�� )
		//session.setAttribute("sidx", sidx);
		
		if(sv != null) { 
			//�α��� ���� ��
			rttr.addAttribute("sidx", sidx);
			str = "redirect:/student/stuDashBoard.do";	
		} else{
			//�α��� ���� �� 
			rttr.addFlashAttribute("loginNok", "�α��ο� �����Ͽ����ϴ�.");
			str = "redirect:/";
		}
		
		return str;
	}
	
	@RequestMapping(value="/student/stuLogout.do", method=RequestMethod.GET)
    public String studentLogout(RedirectAttributes rttr,
    								   HttpSession session) throws Exception{
    
		//�л� �α׾ƿ�
		 //���ǿ� ����� ���� ����
		 session.invalidate();
		 
		 rttr.addFlashAttribute("logout", "�α׾ƿ� �Ͽ����ϴ�.");

		return "redirect:/";
	}
	
	@RequestMapping(value="/student/stuDashBoard.do")
	public String DashBoard(@RequestParam("sidx") String sidx, Model model) {
		//�л� ��ú��� �̵� 
		//���� �̸� ��������(��ú���-���Ǹ��)
		ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(Integer.parseInt(sidx));
		model.addAttribute("stuLecList", stuLecList);
		
		//��ú���-�������
		ArrayList<TaskVO> stuTaskList = ss.stuTaskSelectAll(Integer.parseInt(sidx));
		model.addAttribute("stuTaskList", stuTaskList);
		
		return "/student/stuDashBoard";
	}

	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentpwdCheck() {
		//�л� �������� - ��й�ȣ Ȯ�� ������
		
		return "/student/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/student/pwdCheckAction.do")
	public int studentpwdCheckAction(@RequestParam("pwd") String spwd) {
		//�л� �������� - ��й�ȣ Ȯ�� ���� ajax
		int cnt = ss.studentPwdCheck(spwd);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/stuModify.do")
	public String studentModify(HttpSession session, HttpServletRequest request) {
		//�л� ���� ����ȭ�� �̵�
		int sidx = (Integer)session.getAttribute("sidx");
		StudentVO sv = ss.studentSelectOne(sidx);
		request.setAttribute("sv", sv);

		return "/student/stuModify";
	}

	@RequestMapping(value="/student/stuModifyAction.do")
	public String studentModifyAction(@RequestParam("spwd") String spwd,
									  @RequestParam("semail1") String semail1,
									  @RequestParam("semail2") String semail2,
									  @RequestParam("sphone1") String sphone1,
									  @RequestParam("sphone2") String sphone2,
									  @RequestParam("sphone3") String sphone3
									) {
		//�л� ���� ��������
		String semail = semail1+"@"+semail2;
		String sphone = sphone1 + "-" + sphone2 + "-" +sphone3;
		
		return "redirect:/student/pwdCheck.do";
	}

/*	
	
	@RequestMapping(value="/.do")
	public String studentIdCheck() {
		//�л� ȸ�����Խ� �й�Ȯ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentFindPwd() {
		//�л� ��й�ȣ ã��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeList() {
		//�л�  �˸�ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeNonCheck() {
		//�л�  �˸� ���� üũ
		return null;
	}
	*/
	@RequestMapping(value="/lecture/stuList.do")
	public String enrollList() {
		//�л� ������û ���
		return "lecture/stuList";
	}
	
}
