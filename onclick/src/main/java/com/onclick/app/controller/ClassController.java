//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.EnrollService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//������ ������ ������� ���Ӱ����� �������� Ȯ�� �ʿ�
		//���¾��ε� ȭ��
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//���¾��ε� ����
		int result = cs.classInsert(cv);
		System.out.println("--------------------333-----"+cv.getCsta());
		return "redirect:/lecList.do?lidx="+cv.getLidx();
	}

	@RequestMapping(value="/lecList.do")
	public String classList(@RequestParam("lidx") int lidx, Model model) {
		//���¸���Ʈ ����
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);

		return "lecture/classList";
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
	public String classUpdateAction() {
		//���³��� ���� ����
		return null;
	}
	
	@RequestMapping(value="/classDelete.do")
	public String classDelete(@RequestParam("cidx") int cidx,@RequestParam("lidx") int lidx) {
		//���� ����
		int result = cs.classDelete(cidx);
		String location = "";
		if(result == 1) {
			location="redirect:/lecList.do?lidx="+lidx;
		}
		return location;
	}
	
	
}
