package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService_Mapper {
	
	//기본값 입력 
	public int videoInsert();

	//영상 시청시 시청기록 업데이트
	public int videoUpdate(HashMap<String,Object> hm);
	
	//영상 시청시 시청기록 업데이트
	public int videoUpdateAfter(HashMap<String,Object> hm);
		
	//이전 시청 기록 가져오기
	public VideoAttenDto videoSelectOne(HashMap<String,Object> hm);
	
	//학생 강좌별 수강현황
	public ArrayList<VideoAttenDto> stuAttendence(int sidx);
	
}
