package com.onclick.app.service;

public interface ProfessorService {

	//교수 아이디 중복 체크 
	public int professorIdCheck(String pidx);
	
	//교수 회원가입
	public int professorJoin(int pidx,String pname,String ppwd, int pphone,String pemail);
}
