//211027 jhr 작업
package com.onclick.app.service;

import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService {

	//과제 제출
	public int s_taskInsert(HashMap<String,Object> hm);
	
}
