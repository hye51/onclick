package com.onclick.app.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.TaskVO;
import com.onclick.app.persistence.TaskService_Mapper;

@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public TaskVO taskContent(int tuidx) {
		// ���� ���뺸��
		
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		TaskVO tv = tsm.taskContent(tuidx);
		
		return tv;
	}

}
