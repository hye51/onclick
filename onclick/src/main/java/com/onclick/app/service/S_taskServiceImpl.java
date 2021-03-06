//211027 jhr 작업
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
		//학생 과제 제출
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		hm.put("fidx", null);
		int value = stsm.s_taskUpdate(hm);
		
		return value;
	}

	
	@Override
	@Transactional
	public int s_taskAndFileUpdate(HashMap<String, Object> hm, HashMap<String, Object> stuTaskFile) {
		//과제&파일 제출
		//학생 과제 제출
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
		//학생 제출한 과제 내용보기
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		S_taskDTO std = stsm.s_taskSelectOne(tidx);
		
		return std;
	}

	
	@Override
	public int s_taskModify(HashMap<String, Object> hm) {
		//학생 과제 수정(파일 수정 X)
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value = stsm.s_taskModify(hm);
		
		return value;
	}
	
	
	@Override
	@Transactional
	public int s_taskAndFileModify(HashMap<String,Object> hm, HashMap<String,Object> stuTaskFile) {
		//학생 과제 수정(파일 수정 O)
		//새로운 파일 업로드
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
		//생성되어있는 과제 인덱스 가져가기
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int tidx = stsm.s_taskTidx(sidx, tuidx);
		
		return tidx;
	}


	@Override
	public ArrayList<S_taskDTO> stuTask(int sidx, int lidx) {
		//학생 과제정보 가져가기(학생 과제 목록)
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		ArrayList<S_taskDTO> stlist = stsm.stuTask(sidx,lidx);
		
		return stlist;
	}

	
	@Transactional
	@Override
	public int stuExFileDelete(int tidx, int fidx) {
		//학생 과제 파일 인덱스 삭제
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value1 = stsm.stuExFileDelete(tidx);
		
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		
		return result;
	}


	@Override
	public S_taskDTO s_taskCheck(int sidx, int tuidx) {
		//과제 내용보기 페이지에서 제출 여부 확인
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		S_taskDTO std = stsm.s_taskCheck(sidx, tuidx);
		return std;
	}
	

}
