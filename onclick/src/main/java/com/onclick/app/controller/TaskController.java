package com.onclick.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.TaskService;

@Controller
public class TaskController { //���� ��Ʈ�ѷ�
	
	@Autowired
	TaskService ts;
	
	@RequestMapping(value="/student/taskContent.do")
	public String taskContent(@RequestParam("tuidx") int tuidx,
									 Model model) {
		//��ú��� ���� ��Ͽ��� ���� ���뺸��� �Ѿ��
		TaskVO tv = ts.taskContent(tuidx);
		model.addAttribute("tv", tv);
		
		return "/student/taskContent";
	}
	
/*
	@RequestMapping(value="*.do")
	public String taskWrite() {
		//���� ���� �ۼ� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskWriteAction() {
		//���� ���� �ۼ� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskList() {
		//���� ���� ���
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskContents() {
		//���� ���뺸��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModify() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModifyAction() {
		//���� ���� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskDelete() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskSubmitList() {
		//�л� ���� ���� ���
		return "";
	}
	*/
}
