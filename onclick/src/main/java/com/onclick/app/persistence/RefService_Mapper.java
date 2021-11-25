package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.RefVO;

public interface RefService_Mapper {
	
	//�ڷ� ���
	public ArrayList<RefVO> refSelectAll(HashMap<String, Object> hm);
	
	//�ڷ� ��ü ����
	public int refTotalCount(int lidx);
	
	//�ڷ� ���ε�
	public int refInsert(HashMap<String, Object> hm);
	
	//�ڷ� ���ε�(���� O)
	public int refAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> refFile);
	
	//�ڷ� ���뺸��
	public RefVO refSelectOne(int ridx);
	
	//�ڷ� ���� ����
	public int refModify(HashMap<String, Object> hm);
	
	//�ڷ� ���� & ���� ����
	public int refAndFileModify(HashMap<String, Object> hm);
	
	//���� ���������� ���� ����
	public int rExFileDelete(int ridx);
	
	//���� �������� ����
	public int refDelete(int ridx);
}
