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
		//강의 홈 대시보드 과제 목록
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<TaskVO> tlist = tsm.taskDashSelectAll(lidx);
		return tlist;
	}


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
	@Transactional
	public int taskAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> hmFile, int lidx) {
		//과제 & 파일 업로드
		//파일 업로드
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(hmFile);
		
		//과제 업로드할 때 입력할 첨부파일 인덱스
		int key = Integer.parseInt(String.valueOf(hmFile.get("fidx")));
		
		//과제 업로드
		hm.put("fidx", key);
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value2 = tsm.taskInsert(hm);
		
		//학생 과제 업로드할 때 입력할 과제 인덱스
		int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
		int value3 = tsm.stuTaskDefault(lidx, tuidx);
		
		int result = value1 + value2+ value3;
		
		return result;
	}

	@Override
	@Transactional
	public int taskInsert(HashMap<String, Object> hm, int lidx) {
		//과제만 업로드
		hm.put("fidx", "");
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value1 = tsm.taskInsert(hm);
		
		//학생 과제 업로드할 때 입력할 과제 인덱스
		int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
		int value2 = tsm.stuTaskDefault(lidx, tuidx);
		
		int result = value1+value2;
		
		return result;
	}

	@Override
	public int taskModify(HashMap<String, Object> hm) {
		//과제 수정 (첨부파일 수정 X)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value = tsm.taskModify(hm);
		
		return value;
	}

	
	@Transactional
	@Override
	public int taskAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> hmFile) {
		//과제 수정 (첨부파일 수정 O)
		//파일 업로드
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(hmFile);
		
		//과제 업로드할 때 입력할 첨부파일 인덱스
		int key = Integer.parseInt(String.valueOf(hmFile.get("fidx")));
		hm.put("fidx", key);
		
		//과제&파일 수정
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value2 = tsm.taskFileModify(hm);
		
		int result = value1 + value2;
		
		return result;
	}
	
	
	@Transactional
	@Override
	public int tExFileDelete(int tuidx, int fidx) {
		//과제 파일 인덱스 삭제(ajax)
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
		//과제 삭제 - 학생 과제도 같이 삭제(파일 삭제 X)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		int value1 = tsm.taskDelete(tuidx); //교수 과제 삭제
		int value2 = tsm.stuTaskDelete(tuidx); //학생 과제 삭제
		
		int result = value1 + value2;
		
		return result;
	}

	
	@Override
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx) {
		//학생들 과제 목록(교수 페이지 제출현황)
		TaskService_Mapper tsm = sqlSession.getMapper(TaskService_Mapper.class);
		ArrayList<S_taskDTO> submitList = tsm.taskSubmitList(tuidx);
		
		return submitList;
	}


}
