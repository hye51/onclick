package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService_Mapper {
	
	//강의 공지사항 목록
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//강의 공지사항(대시보드)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//강의 내용보기
	public LecNoticeVO lecNoticeContent(int lnidx);
	
	//강의 공지사항 업로드
	public int lecNoticeInsert(HashMap<String, Object> hm);
	
	//강의 공지사항 수정 (파일 X)
	public int lecNotModify(HashMap<String, Object> hm);
	
	//강의 공지사항 수정 (파일 ))
	public int lecNotAndFileModify(HashMap<String, Object> hm);
	
	//강의 공지사항 수정 - 파일 인덱스 삭제
	public int lnExFileDelete(int lnidx);
	
	//강의 공지사항 삭제
	public int lecNoticeDelete(int lnidx);
}
