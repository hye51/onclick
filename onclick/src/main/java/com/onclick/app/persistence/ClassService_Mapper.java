package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//���� ���ε� 
	public int classInsert(HashMap<String,Object> hm);
	
	//���� ���ε忡 ���� ������ �⺻�� �Է�
	public int stuVideoDefault(int cidx, int lidx);
	
	//���� ����Ʈ 
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//���� ���� �ҷ�����
	public ClassVo classSelectOne(int cidx);
	
}
