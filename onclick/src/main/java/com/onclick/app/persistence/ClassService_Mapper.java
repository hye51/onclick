package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//���� �ۼ� 
	public int classInsert(HashMap<String,Object> hm);
	
	//���� ����Ʈ 
	public ArrayList<ClassVo> classSelect(int lidx);
	
}
