package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RefController { //�ڷ� ��Ʈ�ѷ�
	
	@RequestMapping(value="/refUpload.do")
	public String refWrite() {
		//�ڷ� �ۼ� ȭ��
		return "lecture/refContent_p";
	}
	
	/*
	@RequestMapping(value="*.do")
	public String refWriteAction() {
		//�ڷ� �ۼ� �Ϸ�
		return "";
	}
	*/
	@RequestMapping(value="/refList.do")
	public String refList() {
		//�ڷ� ���
		return "lecture/refList";
	}
	/*
	
	@RequestMapping(value="*.do")
	public String refContents() {
		//�ڷ� ���뺸��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String refModify() {
		//�ڷ� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String refModifyAction() {
		//�ڷ� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String refDelete() {
		//�ڷ� ���� 
		return "";
	}
	*/
}
