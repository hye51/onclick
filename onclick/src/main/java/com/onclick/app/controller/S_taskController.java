//211027 jhr 작업
package com.onclick.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class S_taskController {

	@RequestMapping(value="/.do")
	public String taskWrite() {
		//학생 과제작성 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskWriteAction() {
		//학생 과제작성 실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskDelete() {
		//학생 과제삭제
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String task() {
		//학생 과제작성 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdate() {
		//학생 과제수정 화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdateAction() {
		//학생 과제수정  실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskContents() {
		//학생 과제내용 보기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskList() {
		//학생 과제 리스트보기
		return null;
	}
	
}
