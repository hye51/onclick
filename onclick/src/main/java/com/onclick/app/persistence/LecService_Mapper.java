package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.LecVO;

public interface LecService_Mapper {

	//강의 리스트 가져오기 
	public ArrayList<LecVO> lecSelectAll(int pidx);
	
}
