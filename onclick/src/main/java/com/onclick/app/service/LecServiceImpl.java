package com.onclick.app.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.LecVO;
import com.onclick.app.persistence.LecService_Mapper;

@Service("lecServiceImpl")
public class LecServiceImpl implements LecService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<LecVO> lecSelectAll(int pidx) {
		//강의 리스트 가져오기 
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		ArrayList<LecVO> alist = lsm.lecSelectAll(pidx);
		
		return alist;
	}

}
