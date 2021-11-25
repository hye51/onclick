package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.RefVO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.RefService_Mapper;


@Service("refServiceImpl")
public class RefServiceImpl implements RefService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<RefVO> refSelectAll(HashMap<String, Object> hm) {
		//자료 목록
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		ArrayList<RefVO> rlist = rsm.refSelectAll(hm);
		return rlist;
	}
	

	@Override
	public int refTotalCount(int lidx) {
		//자료 전체 개수
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		int refTC = rsm.refTotalCount(lidx);
		return refTC;
	}


	@Override
	public int refInsert(HashMap<String, Object> hm) {
		//자료 업로드 (파일 X)
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		int value = rsm.refInsert(hm);
		return value;
	}

	@Transactional
	@Override
	public int refAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> refFile) {
		//자료 업로드 (파일 O)
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(refFile);
		int fidx = Integer.parseInt(String.valueOf(refFile.get("fidx")));
		
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		hm.put("fidx", fidx);
		int value2 = rsm.refInsert(hm);
		
		int result = value1 + value2;
		return result;
	}

	@Override
	public RefVO refSelectOne(int ridx) {
		//자료 내용보기
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		RefVO rv = rsm.refSelectOne(ridx);
		return rv;
	}

	@Override
	public int refModify(HashMap<String, Object> hm) {
		//자료 수정(파일 X)
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		int value = rsm.refModify(hm);
		return value;
	}

	
	@Transactional
	@Override
	public int refAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> refFile) {
		//자료 수정(파일 O)
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value1 = fsm.fileInsert(refFile);
		int fidx = Integer.parseInt(String.valueOf(refFile.get("fidx")));
		
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		hm.put("fidx", fidx);
		int value2 = rsm.refAndFileModify(hm);
		
		int result = value1 + value2;
		return result;
	}

	@Transactional
	@Override
	public int rExFileDelete(int ridx, int fidx) {
		//수정 페이지에서 파일 삭제
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		int value1 = rsm.rExFileDelete(ridx);
		
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value2 = fsm.fileDelete(fidx);
		
		int result = value1 + value2;
		return result;
	}

	@Override
	public int refDelete(int ridx) {
		//자료 삭제
		RefService_Mapper rsm = sqlSession.getMapper(RefService_Mapper.class);
		int value = rsm.refDelete(ridx);
		
		return value;
	}

}
