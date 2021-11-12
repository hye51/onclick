package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

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
	public TaskVO taskSelectOne(int tuidx) {
		//과제 내용보기
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		TaskVO tv = tsm.taskSelectOne(tuidx);

		return tv;
	}

	@Override
	public ArrayList<TaskVO> taskSelectAll(int lidx) {
		//과제 목록
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<TaskVO> tlist = tsm.taskSelectAll(lidx);
		
		return tlist;
	}

	@Override
	public int taskInsert(HashMap<String, Object> hm) {
		//과제 업로드
		return 0;
	}

}
