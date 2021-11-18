//211027 jhr 작업
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
		//교수만 가능한 기능으로 접속계정이 교수인지 확인 필요
		//강좌업로드 화면
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//강좌업로드 실행
		int result = cs.classInsert(cv);
		System.out.println("--------------------333-----"+cv.getCsta());
		return "redirect:/lecList.do?lidx="+cv.getLidx();
	}

	@RequestMapping(value="/lecList.do")
	public String classList(@RequestParam("lidx") int lidx, Model model) {
		//강좌리스트 보기
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);

		return "lecture/classList";
	}
	
	@RequestMapping(value="/classUpdate.do")
	public String classUpdate(@RequestParam("cidx") int cidx, Model model) {
		//강좌내용 수정화면
		ClassVo cv = cs.classSelectOne(cidx);
		
	/*	String csta = cv.getCsta();	
		//replace([기존문자],[바꿀문자])
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
		//강좌내용 수정 실행
		return null;
	}
	
	@RequestMapping(value="/classDelete.do")
	public String classDelete(@RequestParam("cidx") int cidx,@RequestParam("lidx") int lidx) {
		//강좌 삭제
		int result = cs.classDelete(cidx);
		String location = "";
		if(result == 1) {
			location="redirect:/lecList.do?lidx="+lidx;
		}
		return location;
	}
	
	
}
