//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService {

	//���� �ۼ� 
	public int classInsert(ClassVo cv);
	
	//���� ����Ʈ
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//���� ���� �ҷ�����
	public ClassVo classSelectOne(int cidx);
	
}
