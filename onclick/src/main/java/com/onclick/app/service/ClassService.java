//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService {

	//���� �ۼ� 
	public HashMap<String,Object> classInsert(ClassVo cv);
	
	//���� ����Ʈ
	public ArrayList<ClassVo> classSelect(int lidx);
	
	//���� ���� �ҷ�����
	public ClassVo classSelectOne(int cidx);
	
	//���� ���� 
	public int classDelete(int cidx);
	
	//���� ���� ���� 
	public int classUpdate(ClassVo cv);
	
	//���� Ȩ ��ú��� - ���� ������ ����(�ش� ���� �ϳ�)
	public ArrayList<ClassVo> classFinDash(int lidx);
	
	//�л� ��ú��� - ���� ������ ����(���� ��ü)
	public ArrayList<ClassVo> classAllFinDash(int sidx);
}
