package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.LecVO;

public interface LecService {

	//강의 리스트 가져오기 
	public ArrayList<LecVO> lecSelectAll(int pidx);
	
	//강의홈가기
	public LecVO lecHome(int lidx);
	
	//해당 강의 정보 가져오기
	public LecVO lecSelectOne(int lidx);
}
