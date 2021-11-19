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
		//���� �������� ���
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lnList = lnsm.lecNoticeSelectAll(lidx);
		return lnList;
	}

	@Override
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx) {
		//���� �������� ���(��ú���)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lndList = lnsm.lecNoticeSelectDash(lidx);
		return lndList;
	}

	@Override
	public LecNoticeVO lecNoticeContent(int lnidx) {
		//���� �������� ���뺸��
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		LecNoticeVO lnv = lnsm.lecNoticeContent(lnidx);
		
		return lnv;
	}

	@Override
	public int lecNoticeInsert(HashMap<String, Object> hm) {
		// ���� �������� ���ε�(���� X)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value = lnsm.lecNoticeInsert(hm);
		
		return value;
	}
	
	@Transactional
	@Override
	public int lecNoticeAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile) {
		//���� �������� ���ε� (���� O)
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
		//���� �������׸� ����
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int lndel = lnsm.lecNoticeDelete(lnidx);
		
		return lndel;
	}

	@Override
	public int lecNotModify(HashMap<String, Object> hm) {
		//���� �������� ����(���� X)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value = lnsm.lecNotModify(hm);
		
		return value;
	}
	
	@Transactional
	@Override
	public int lecNotAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> lecNoticeFile) {
		//���� �������� ����(���� O)
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		//���ο� ���� insert
		int value1 = fsm.fileInsert(lecNoticeFile);
		//���ο� ���� �ε��� �����ؼ� ����
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
		//���� �������� ���� - ���ϸ� ����(ajax)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		int value1 = lnsm.lnExFileDelete(lnidx);
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		
		return result;
	}
}
