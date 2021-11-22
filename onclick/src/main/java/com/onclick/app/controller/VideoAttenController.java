//211027 jhr 작업
package com.onclick.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.VideoAttenService;

@Controller
public class VideoAttenController {
	
	@Autowired
	VideoAttenService vs;
	
	@Autowired
	ClassService cs;
	
	@Autowired
	LecService ls;
	
	/*
	
	@RequestMapping(value="/.do")
	public String videoContents() {
		//시청기록 버튼 누르는 경우
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoLevelUpdate() {
		//동영상 시청후 강의난이도 작성
		return null;
	}
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(VideoAttenDto vd, HttpSession session) {
		//시청중 멈춘경우(창을 닫은 경우, 로그아웃된 경우, 정지버튼을 누른경우)
		//전체시간,시작시간,종료시간 받아옴
		vd.setSidx((Integer)session.getAttribute("sidx"));
		System.out.println("시청업데이트vd.getVpercent()  : " +vd.getVpercent() );
		int result=vs.videoUpdate(vd);
		System.out.println("시청업데이트 시  : " +result );
		return result;
	}
	
	/*
	@RequestMapping(value="/.do")
	public String videoStart() {
		//시청시작 버튼 누른 경우
		return null;
	}

	 */

	@RequestMapping(value="/stuLecContent.do")
	public String lecContent(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model,HttpSession session) {
		//학생 동영상 출석 화면
		//강의정보
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
		int lidx = cv.getLidx();
		
		//해당 과목 정보 가져오기(알림으로 넘어온 경우)
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
				
		//이전 시청기록 
		VideoAttenDto vd = vs.videoSelectOne(sidx, cidx);
		model.addAttribute("vd", vd);

		return "lecture/stuLecContent";
	}
	
	
	@RequestMapping(value="/proLecContent.do")
	public String videoProAtten(@RequestParam("pidx") int pidx, @RequestParam("cidx") int cidx, Model model) {
		//교수 동영상 출석 화면
		//강의정보
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
		
		
		return "lecture/proLecContent";
	}
	
}
