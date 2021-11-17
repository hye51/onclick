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
	
	@Autowired
	EnrollService es;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//���¾��ε� ȭ��
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//������ ������ ������� ���Ӱ����� �������� Ȯ�� �ʿ�
		//���¾��ε� ����
		int result = cs.classInsert(cv);
		/*
		 * if(result ==1 ) { //���ε� ������ �����л� ���� insert ArrayList<Integer> stuList =
		 * es.enrollStuList(cv.getLidx()); System.out.println("=====" + stuList);
		 * 
		 * 
		 * }
		 */
		return "redirect:/lecList.do?lidx="+cv.getLidx();
	}
	
/*	
	@RequestMapping(value="/.do")
	public String classContents() {
		//���³��뺸��? ������?
		return null;
	}
*/	
	@RequestMapping(value="/lecList.do")
	public String classList(@RequestParam("lidx") int lidx, Model model) {
		//���¸���Ʈ ����
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);

		return "lecture/classList";
	}
/*	
	@RequestMapping(value="/.do")
	public String classUpdate() {
		//���³��� ����ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdateAction() {
		//���³��� ���� ����
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDelete() {
		//���³��� ����ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDeleteAction() {
		//���³��� ���� ����
		return null;
	}
*/	
	
}
