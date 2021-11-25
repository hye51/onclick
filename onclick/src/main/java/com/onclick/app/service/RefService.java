package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.RefVO;

public interface RefService {

	//�ڷ� ���
	public ArrayList<RefVO> refSelectAll(HashMap<String, Object> hm);
	
	//�ڷ� ��ü ����
	public int refTotalCount(int lidx);
	
	//�ڷ� ���ε�(���� X)
	public int refInsert(HashMap<String, Object> hm);

	//�ڷ� ���ε�(���� O)
	public int refAndFileInsert(HashMap<String, Object> hm, HashMap<String, Object> refFile);
	
	//�ڷ� ���뺸��
	public RefVO refSelectOne(int ridx);
	
	//�ڷ� ����(���� X)
	public int refModify(HashMap<String, Object> hm);
	
	//�ڷ� ����(���� O)
	public int refAndFileModify(HashMap<String, Object> hm, HashMap<String, Object> refFile);
	
	//���� ���������� ���� ����
	public int rExFileDelete(int ridx, int fidx);
	
	//���� �������� ����
	public int refDelete(int ridx);
}
