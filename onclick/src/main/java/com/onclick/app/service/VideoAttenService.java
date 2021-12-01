//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService {


	//영상 시청시 시청기록 업데이트
	public int videoUpdate(VideoAttenDto vd);
	
	//영상 시청 기록 업데이트(출석기간 지난 강의에 대해)
	public int videoUpdateAfter(VideoAttenDto vd);
	
	//이전 시청 기록 가져오기
	public VideoAttenDto videoSelectOne(int sidx, int cidx);
	
	//학생 강좌별 수강현황
	public ArrayList<VideoAttenDto> stuAttendence(int sidx);
	
	//강의 평가
	public int videoLevelUpdate(int vlevel, int vidx);
}
