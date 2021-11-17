package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//°­ÁÂ ÀÛ¼º 
	public int classInsert(HashMap<String,Object> hm);
	
	//°­ÁÂ ¸®½ºÆ® 
	public ArrayList<ClassVo> classSelect(int lidx);
	
}
