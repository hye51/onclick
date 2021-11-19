package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.LecNoticeService_Mapper;

@Service("lecNoticeServiceImpl")
public class LecNoticeServiceImpl implements LecNoticeService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx) {
		//강의 공지사항 목록
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lnList = lnsm.lecNoticeSelectAll(lidx);
		return lnList;
	}

	@Override
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx) {
		//강의 공지사항 목록(대시보드)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lndList = lnsm.lecNoticeSelectDash(lidx);
		return lndList;
	}

	@Override
	public LecNoticeVO lecNoticeContent(int lnidx) {
		//강의 공지사항 내용보기
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		LecNoticeVO lnv = lnsm.lecNoticeContent(lnidx);
		
		return lnv;
	}

	@Override
	public int lecNoticeInsert(HashMap<String, Object> hm) {
		// 강의 공지사항 업로드(파일 X)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value = lnsm.lecNoticeInsert(hm);
		
		return value;
	}
	
	@Transactional
	@Override
	public int lecNoticeAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile) {
		//강의 공지사항 업로드 (파일 O)
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(lecNoticeFile);
		int fidx = Integer.parseInt(String.valueOf(lecNoticeFile.get("fidx")));
		
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		hm.put("fidx", fidx);
		int value2 = lnsm.lecNoticeInsert(hm);
		
		int result = value1 + value2;
		
		return result;
	}
	

	@Override
	public int lecNoticeDelete(int lnidx) {
		//강의 공지사항만 삭제
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int lndel = lnsm.lecNoticeDelete(lnidx);
		
		return lndel;
	}

	@Override
	public int lecNotModify(HashMap<String, Object> hm) {
		//강의 공지사항 수정(파일 X)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value = lnsm.lecNotModify(hm);
		
		return value;
	}
	
	@Transactional
	@Override
	public int lecNotAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile) {
		//강의 공지사항 수정(파일 O)
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		//새로운 파일 insert
		int value1 = fsm.fileInsert(lecNoticeFile);
		//새로운 파일 인덱스 포함해서 수정
		int fidx = Integer.parseInt(String.valueOf(lecNoticeFile.get("fidx")));
		
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		hm.put("fidx", fidx);
		int value2 = lnsm.lecNotModify(hm);
		
		int result = value1 + value2;
		
		return result;
	}

	@Transactional
	@Override
	public int lnExFileDelete(int lnidx, int fidx) {
		//강의 공지사항 수정 - 파일만 삭제(ajax)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value1 = lnsm.lnExFileDelete(lnidx);
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		
		return result;
	}
}
