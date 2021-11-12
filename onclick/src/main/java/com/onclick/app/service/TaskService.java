package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService {
	
	//과제 내용보기
	public TaskVO taskSelectOne(int tuidx);

	//과제 목록
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//과제 업로드
	public int taskInsert(HashMap<String,Object> hm);
}
