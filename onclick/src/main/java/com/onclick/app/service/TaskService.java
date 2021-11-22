package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.Criteria;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;

public interface TaskService { //교수 과제
	
	//강의 홈 대시보드 과제 목록
	public ArrayList<TaskVO> taskDashSelectAll(int lidx);
	
	//과제 내용보기
	public TaskVO taskSelectOne(int tuidx);

	//과제 목록
	public ArrayList<TaskVO> taskSelectAll(HashMap<String, Object> hm);
	
	//전체 개수 가져오기
	public int taskTotalCount(int lidx);
	
	//과제 & 파일 업로드
	public int taskAndFileInsert(HashMap<String,Object> hm,HashMap<String, Object> hmFile, int lidx);
	
	//과제만 업로드
	public int taskInsert(HashMap<String,Object> hm, int lidx);
	
	//과제 수정
	public int taskModify(HashMap<String,Object> hm);
	
	//과제 & 파일 수정
	public int taskAndFileModify(HashMap<String,Object> hm,HashMap<String, Object> hmFile);
	
	//과제 파일인덱스 삭제(ajax)
	public int tExFileDelete(int tuidx, int fidx);
	
	//과제 삭제
	public int taskDelete(int tuidx);
	
	//학생들 과제 목록(교수 페이지 제출현황)
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx);
}
