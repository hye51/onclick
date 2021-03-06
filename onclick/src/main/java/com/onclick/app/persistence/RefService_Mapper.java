package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.RefVO;

public interface RefService_Mapper {
	
	//자료 목록
	public ArrayList<RefVO> refSelectAll(HashMap<String, Object> hm);
	
	//자료 전체 개수
	public int refTotalCount(int lidx);
	
	//자료 업로드
	public int refInsert(HashMap<String, Object> hm);
	
	//자료 업로드(파일 O)
	public int refAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> refFile);
	
	//자료 내용보기
	public RefVO refSelectOne(int ridx);
	
	//자료 내용 수정
	public int refModify(HashMap<String, Object> hm);
	
	//자료 내용 & 파일 수정
	public int refAndFileModify(HashMap<String, Object> hm);
	
	//수정 페이지에서 파일 삭제
	public int rExFileDelete(int ridx);
	
	//강의 공지사항 삭제
	public int refDelete(int ridx);
}
