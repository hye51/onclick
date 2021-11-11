package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService_Mapper {

	//과제 제출
	public int s_taskInsert(HashMap<String,Object> hm);
}
