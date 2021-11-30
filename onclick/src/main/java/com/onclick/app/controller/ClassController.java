//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.EnrollService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.NoticeService;
import com.onclick.app.service.VideoAttenService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@Autowired
	VideoAttenService vs;
	
	@Autowired
	NoticeService ns;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//������ ������ ������� ���Ӱ����� �������� Ȯ�� �ʿ�
		//���¾��ε� ȭ��
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv,HttpSession session) {
		//���¾��ε� ����
		HashMap<String,Object> value = cs.classInsert(cv);
		
		if(cv.getCnotyn().equals("Y")) {
			//���¾��ε� �˸� 
			String pname= (String)session.getAttribute("pname");
			int cidx = (Integer)value.get("cidx");
			int cnt = ns.alarmClassInsert(cv.getLidx(),cidx,pname);
		}
		return "redirect:/proLecList.do?lidx="+cv.getLidx();
	}

	@RequestMapping(value="/proLecList.do")
	public String proClassList(@RequestParam("lidx") int lidx, Model model) {
		//���� ���¸���Ʈ ����
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);
		System.out.println("���� ���¸���Ʈ ����");
		
		return "lecture/proClassList";
	}
	
	@RequestMapping(value="/stuLecList.do")
	public String stuClassList(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		//�л� ���¸���Ʈ ����
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);
		int sidx = (Integer)session.getAttribute("sidx");
		
		//���� ���� ��Ȳ
		ArrayList<VideoAttenDto> stuAttList = vs.stuAttendence(sidx);
		model.addAttribute("stuAttList", stuAttList);
		
		return "lecture/stuClassList";
	}
	
	@RequestMapping(value="/classUpdate.do")
	public String classUpdate(@RequestParam("cidx") int cidx, Model model) {
		//���³��� ����ȭ��
		ClassVo cv = cs.classSelectOne(cidx);
		
	/*	String csta = cv.getCsta();	
		//replace([��������],[�ٲܹ���])
		csta= csta.replace("/", "-");	
		cv.setCsta(csta);

		String cfin = cv.getCfin();	
		cfin= cfin.replace("/", "-");	
		cv.setCfin(cfin);
	*/	
		model.addAttribute("cv", cv);
		
		return "lecture/lecModify";
	}
	
	@RequestMapping(value="/classUpdateAction.do")
	public String classUpdateAction(ClassVo cv) {
		//���³��� ���� ����
		int result = cs.classUpdate(cv);

		return "redirect:/proLecList.do?lidx="+cv.getLidx();
	}
	
	@RequestMapping(value="/classDelete.do")
	public String classDelete(@RequestParam("cidx") int cidx,
							  @RequestParam("lidx") int lidx,
							  RedirectAttributes rttr,
							  HttpSession session) {
		//���� ����
		int result = cs.classDelete(cidx);
		String location = "";
		if(result == 1) {
			//���� ������ �ش� �˸� ����
			int cnt=ns.alarmClassDelete(cidx);
			
			rttr.addFlashAttribute("deleteOk", "�����Ͽ����ϴ�.");
			location="redirect:/proLecList.do?lidx="+lidx;
		}else {
			rttr.addFlashAttribute("deleteNok", "������ �����Ͽ����ϴ�.");
			location="redirect:/proLecContent.do?cidx="+cidx+"&pidx="+session.getAttribute("pidx");
		}
		return location;
	}
	
	
}
