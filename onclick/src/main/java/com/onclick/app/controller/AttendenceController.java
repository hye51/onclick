//211027 jhr 작업
package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttendenceController {

	@RequestMapping(value="/stuAttend.do")
	public String attenStudent(@RequestParam("lidx") int lidx) {
		//학생 개인 출석확인 화면
		return "student/attend";
	}
	
	@RequestMapping(value="/proAttend.do")
	public String attenProList(@RequestParam("lidx") int lidx) {
		//교수 학생 전체 출석확인 화면
		return "professor/allAttend";
	}
/*	
	@RequestMapping(value="/.do")
	public String attenProUpdate() {
		//교수 전체학생에 대한 출석수정 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String attenProUpdateAction() {
		//교수 전체학생에 대한 출석수정 완료
		return null;
	}
	*/
}
