package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.TaskVO;

public interface TaskService {
	
	//과제 내용보기
	public TaskVO taskContent(int tuidx);

	//과제 목록
	public ArrayList<TaskVO> taskSelectAll(int lidx);
}
