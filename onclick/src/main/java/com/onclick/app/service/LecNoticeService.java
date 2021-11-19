package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService {
	
	//강의 공지사항 목록
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//강의 공지사항(대시보드)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//강의 공지사항 내용보기
	public LecNoticeVO lecNoticeContent(int lnidx);
	
	//강의 공지사항 업로드 (파일 X)
	public int lecNoticeInsert(HashMap<String, Object> hm);
	
	//강의 공지사항 업로드 (파일 O)
	public int lecNoticeAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile);
	
	//강의 공지사항 수정 (파일 X)
	public int lecNotModify(HashMap<String, Object> hm);
	
	//강의 공지사항 수정 (파일 O)
	public int lecNotAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile);
	
	//강의 공지사항 수정 -파일인덱스 삭제(ajax)
	public int lnExFileDelete(int lnidx, int fidx);
	
	//강의 공지사항 삭제
	public int lecNoticeDelete(int lnidx);
}
