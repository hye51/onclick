//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.S_taskService_Mapper;
import com.onclick.app.persistence.TaskService_Mapper;

@Service("s_taskServiceImpl")
public class S_taskServiceImpl implements S_taskService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int s_taskUpdate(HashMap<String,Object> hm) {
		//�л� ���� ����
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		hm.put("fidx", null);
		int value = stsm.s_taskUpdate(hm);
		
		return value;
	}

	
	@Override
	@Transactional
	public int s_taskAndFileUpdate(HashMap<String, Object> hm, HashMap<String, Object> stuTaskFile) {
		//����&���� ����
		//�л� ���� ����
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int fileInsert =stsm.s_taskFileInsert(stuTaskFile);
		int key = Integer.parseInt(String.valueOf(stuTaskFile.get("fidx")));
		
		hm.put("fidx", key);
		int taskInsert = stsm.s_taskUpdate(hm);
		
		int result = fileInsert + taskInsert;
		
		return result;
	}

	
	@Override
	public S_taskDTO s_taskSelectOne(int tidx) {
		//�л� ������ ���� ���뺸��
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		S_taskDTO std = stsm.s_taskSelectOne(tidx);
		
		return std;
	}

	
	@Override
	public int s_taskModify(HashMap<String, Object> hm) {
		//�л� ���� ����(���� ���� X)
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value = stsm.s_taskModify(hm);
		
		return value;
	}
	
	
	@Override
	@Transactional
	public int s_taskAndFileModify(HashMap<String,Object> hm, HashMap<String,Object> stuTaskFile) {
		//�л� ���� ����(���� ���� O)
		//���ο� ���� ���ε�
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value1 =stsm.s_taskFileInsert(stuTaskFile);
		int key = Integer.parseInt(String.valueOf(stuTaskFile.get("fidx")));
		
		hm.put("fidx", key);
		int value2 = stsm.s_taskFileModify(hm);
		
		int result = value1+value2;
		
		return result;
	}

	@Override
	public int s_taskTidx(int sidx, int tuidx) {
		//�����Ǿ��ִ� ���� �ε��� ��������
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int tidx = stsm.s_taskTidx(sidx, tuidx);
		
		return tidx;
	}


	@Override
	public ArrayList<S_taskDTO> stuTask(int sidx) {
		//�л� �������� ��������(�л� ���� ���)
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		ArrayList<S_taskDTO> stlist = stsm.stuTask(sidx);
		
		return stlist;
	}

	
	@Transactional
	@Override
	public int stuExFileDelete(int tidx, int fidx) {
		//�л� ���� ���� �ε��� ����
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value1 = stsm.stuExFileDelete(tidx);
		
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		
		return result;
	}


	@Override
	public S_taskDTO s_taskCheck(int sidx, int tuidx) {
		//���� ���뺸�� ���������� ���� ���� Ȯ��
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		S_taskDTO std = stsm.s_taskCheck(sidx, tuidx);
		return std;
	}
	

}
