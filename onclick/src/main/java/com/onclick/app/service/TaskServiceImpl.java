package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.S_taskService_Mapper;
import com.onclick.app.persistence.TaskService_Mapper;

@Service("taskServiceImpl")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<TaskVO> taskDashSelectAll(int lidx) {
		//���� Ȩ ��ú��� ���� ���
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<TaskVO> tlist = tsm.taskDashSelectAll(lidx);
		return tlist;
	}


	@Override
	public TaskVO taskSelectOne(int tuidx) {
		//���� ���뺸��
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		TaskVO tv = tsm.taskSelectOne(tuidx);

		return tv;
	}

	@Override
	public ArrayList<TaskVO> taskSelectAll(int lidx) {
		//���� ���
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<TaskVO> tlist = tsm.taskSelectAll(lidx);
		
		return tlist;
	}
	
	@Override
	@Transactional
	public int taskAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> hmFile, int lidx) {
		//���� & ���� ���ε�
		//���� ���ε�
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(hmFile);
		
		//���� ���ε��� �� �Է��� ÷������ �ε���
		int key = Integer.parseInt(String.valueOf(hmFile.get("fidx")));
		
		//���� ���ε�
		hm.put("fidx", key);
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value2 = tsm.taskInsert(hm);
		
		//�л� ���� ���ε��� �� �Է��� ���� �ε���
		int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
		int value3 = tsm.stuTaskDefault(lidx, tuidx);
		
		int result = value1 + value2+ value3;
		
		return result;
	}

	@Override
	@Transactional
	public int taskInsert(HashMap<String, Object> hm, int lidx) {
		//������ ���ε�
		hm.put("fidx", "");
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value1 = tsm.taskInsert(hm);
		
		//�л� ���� ���ε��� �� �Է��� ���� �ε���
		int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
		int value2 = tsm.stuTaskDefault(lidx, tuidx);
		
		int result = value1+value2;
		
		return result;
	}

	@Override
	public int taskModify(HashMap<String, Object> hm) {
		//���� ���� (÷������ ���� X)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value = tsm.taskModify(hm);
		
		return value;
	}

	
	@Transactional
	@Override
	public int taskAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> hmFile) {
		//���� ���� (÷������ ���� O)
		//���� ���ε�
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(hmFile);
		
		//���� ���ε��� �� �Է��� ÷������ �ε���
		int key = Integer.parseInt(String.valueOf(hmFile.get("fidx")));
		hm.put("fidx", key);
		
		//����&���� ����
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value2 = tsm.taskFileModify(hm);
		
		int result = value1 + value2;
		
		return result;
	}
	
	
	@Transactional
	@Override
	public int tExFileDelete(int tuidx, int fidx) {
		//���� ���� �ε��� ����(ajax)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value1 = tsm.tExFileDelete(tuidx);
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		
		return result;
	}
	
	
	@Transactional
	@Override
	public int taskDelete(int tuidx) {
		//���� ���� - �л� ������ ���� ����(���� ���� X)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value1 = tsm.taskDelete(tuidx); //���� ���� ����
		int value2 = tsm.stuTaskDelete(tuidx); //�л� ���� ����
		
		int result = value1 + value2;
		
		return result;
	}

	
	@Override
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx) {
		//�л��� ���� ���(���� ������ ������Ȳ)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<S_taskDTO> submitList = tsm.taskSubmitList(tuidx);
		
		return submitList;
	}


}
