package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//강좌 업로드 
	public int classInsert(HashMap<String,Object> hm);
	
	//강좌 업로드에 따른 동영상 기본값 입력
	public int stuVideoDefault(int cidx, int lidx);
	
	//강좌 리스트 
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//강좌 내용 불러오기
	public ClassVo classSelectOne(int cidx);
	
}
