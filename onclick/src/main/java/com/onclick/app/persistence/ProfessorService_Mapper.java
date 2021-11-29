package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.ProfessorVO;

public interface ProfessorService_Mapper {

	//���� ���̵� �ߺ� üũ
	public int professorIdCheck(HashMap<String,String> hm);
	
	//���� ȸ������
	public int professorJoin(HashMap<String,Object> hm);
	
	//���� �α��� 
	public ProfessorVO professorLogin(HashMap<String,Object> hm);
	
	//���� ��й�ȣ Ȯ��
	public int proPwdCheck(HashMap<String,String> hm);
	
	//���� ���� ���� 
	public ProfessorVO proInfo(int pidx);
	
	//���� ���� ����
	public int professorModifyAction(HashMap<String, Object> hm);
}
