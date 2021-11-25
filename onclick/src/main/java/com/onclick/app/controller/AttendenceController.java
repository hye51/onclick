//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendenceController {

	@RequestMapping(value="/stuAttend.do")
	public String attenStudent(@RequestParam("lidx") int lidx) {
		//�л� ���� �⼮Ȯ�� ȭ��
		return "student/attend";
	}
	
	@RequestMapping(value="/proAttend.do")
	public String attenProList(@RequestParam("lidx") int lidx) {
		//���� �л� ��ü �⼮Ȯ�� ȭ��
		return "professor/allAttend";
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
