//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService {

	//생성되어있는 과제 번호 가져가기
	public int s_taskTidx(int sidx, int tuidx);
	
	//과제만 제출
	public int s_taskUpdate(HashMap<String,Object> hm);
	
	//과제&파일 제출
	public int s_taskAndFileUpdate(HashMap<String,Object> hm, HashMap<String,Object> stuTaskFile);
	
	//제출한 과제 내용보기
	public S_taskDTO s_taskSelectOne(int tidx);
	
	//제출 여부 확인
	public S_taskDTO s_taskCheck(int sidx, int tuidx);
	
	//과제 수정 (파일 수정 X)
	public int s_taskModify(HashMap<String,Object> hm);
	
	//과제 수정(파일 수정O)
	public int s_taskAndFileModify(HashMap<String,Object> hm, HashMap<String,Object> stuTaskFile);
	
	//과제 파일인덱스 삭제
	public int stuExFileDelete(int tidx, int fidx);
	
	//학생 과제 정보 가져가기(학생 과제 목록)
	public ArrayList<S_taskDTO> stuTask(int sidx);
	
}
