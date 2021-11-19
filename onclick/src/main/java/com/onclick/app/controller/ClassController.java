//211027 jhr 작업
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
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.EnrollService;
import com.onclick.app.service.VideoAttenService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@Autowired
	VideoAttenService vs;
	
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
	
		return "redirect:/proLecList.do?lidx="+cv.getLidx();
	}

	@RequestMapping(value="/proLecList.do")
	public String proClassList(@RequestParam("lidx") int lidx, Model model) {
		//교수 강좌리스트 보기
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);
		System.out.println("교수 강좌리스트 보기");
		
		return "lecture/proClassList";
	}
	
	@RequestMapping(value="/stuLecList.do")
	public String stuClassList(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		//학생 강좌리스트 보기
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);
		int sidx = (Integer)session.getAttribute("sidx");
		
		//강좌 수강 현황
		ArrayList<VideoAttenDto> stuAttList = vs.stuAttendence(sidx);
		model.addAttribute("stuAttList", stuAttList);
		
		return "lecture/stuClassList";
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
	public String classUpdateAction(ClassVo cv) {
		//강좌내용 수정 실행
		int result = cs.classUpdate(cv);

		return "redirect:/lecList.do?lidx="+cv.getLidx();
	}
	
	@RequestMapping(value="/classDelete.do")
	public String classDelete(@RequestParam("cidx") int cidx,
							  @RequestParam("lidx") int lidx,
							  RedirectAttributes rttr,
							  HttpSession session) {
		//강좌 삭제
		int result = cs.classDelete(cidx);
		String location = "";
		if(result == 1) {
			rttr.addFlashAttribute("deleteOk", "삭제하였습니다.");
			location="redirect:/lecList.do?lidx="+lidx;
		}else {
			rttr.addFlashAttribute("deleteNok", "삭제에 실패하였습니다.");
			location="redirect:/proLecContent.do?cidx="+cidx+"&pidx="+session.getAttribute("pidx");
		}
		return location;
	}
	
	
}
