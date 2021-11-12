package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService_Mapper {

	//과제 제출
	public int s_taskInsert(HashMap<String,Object> hm);
	
	//제출한 과제 내용보기
	public S_taskDTO s_taskSelectOne(int tuidx, int sidx);
	
	//과제 수정
	public int s_taskUpdate(HashMap<String,Object> hm);
}
