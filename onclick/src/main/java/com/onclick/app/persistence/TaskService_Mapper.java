package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService_Mapper {

	//과제 내용보기
	public TaskVO taskContent(int tuidx);
}
