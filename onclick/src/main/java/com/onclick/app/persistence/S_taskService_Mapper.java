package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService_Mapper {

	//생성되어있는 과제 번호 가져가기
	public int s_taskTidx(int sidx, int tuidx);
	
	//과제 제출
	public int s_taskUpdate(HashMap<String,Object> hm);
	
	//파일 제출
	public int s_taskFileInsert(HashMap<String,Object> stuTaskFile);
	
	//제출한 과제 내용보기
	public S_taskDTO s_taskSelectOne(int tidx);
	
	//제출 여부 확인
	public S_taskDTO s_taskCheck(int sidx, int tuidx);
	
	//과제 수정 (파일 수정 X)
	public int s_taskModify(HashMap<String,Object> hm);
	
	//과제 수정(파일 수정 O)
	public int s_taskFileModify(HashMap<String,Object> hm);
	
	//과제 파일인덱스 삭제
	public int stuExFileDelete(int tidx);

	//학생 과제 정보 가져가기(학생 과제 목록)
	public ArrayList<S_taskDTO> stuTask(int sidx);
	
	//학생 제출한 과제 삭제
	public int s_taskDelete(int tidx);
}
