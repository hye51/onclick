package com.onclick.app.service;

import com.onclick.app.domain.ProfessorVO;

public interface ProfessorService {

	//���� ���̵� �ߺ� üũ 
	public int professorIdCheck(String pidx);
	
	//���� ȸ������
	public int professorJoin(int pidx,String pname,String ppwd, int pphone,String pemail);
	
	//���� �α��� 
	public ProfessorVO professorLogin(int pidx, String ppwd);
	
	//���� ��й�ȣ Ȯ��
	public int proPwdCheck(String ppwd);
	
	//���� ���� ���� 
	public int professorModifyAction(int pidx, String ppwd);

	//���� ���� ���� 
	public ProfessorVO proInfo(int pidx);
}
