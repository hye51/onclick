//211027 jhr 작업
package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.service.ClassService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//강좌업로드 화면
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//강좌업로드 실행
		int result = cs.classInsert(cv);
		return "lecture/classList";
	}
	
	/*
	@RequestMapping(value="/.do")
	public String classContents() {
		//강좌내용보기? 동영상?
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classList() {
		//강좌리스트 보기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdate() {
		//강좌내용 수정화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdateAction() {
		//강좌내용 수정 실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDelete() {
		//강좌내용 삭제화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDeleteAction() {
		//강좌내용 삭제 실행
		return null;
	}
*/	
	
}
