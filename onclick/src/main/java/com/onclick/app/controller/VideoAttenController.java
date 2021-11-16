//211027 jhr 작업
package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.VideoAttenService;

@Controller
public class VideoAttenController {
	
	@Autowired
	VideoAttenService vs;
	
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
	public int videoEnd(VideoAttenDto vd) {
		//시청중 멈춘경우(창을 닫은 경우, 로그아웃된 경우, 정지버튼을 누른경우)
		//전체시간,시작시간,종료시간 받아옴
		int vpercent = vd.getVend()-vd.getVstart();
		System.out.println(vpercent + "," + vd.getCidx());

		
		int result=vs.videoUpdate(vd);
		System.out.println("controller : " + result);
		
		return 1;
	}
	
	/*
	@RequestMapping(value="/.do")
	public String videoStart() {
		//시청시작 버튼 누른 경우
		return null;
	}

	 */

	
	@RequestMapping(value="/lecContent.do")
	public String lecContent() {
		//학생 동영상 출석 화면
		return "lecture/lecContent_p";
	}
	
/*	
	@RequestMapping(value="/.do")
	public String videoProAtten() {
		//교수 동영상 출석 화면
		return null;
	}
*/	
}
