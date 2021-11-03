package com.onclick.app.persistence;

import java.util.HashMap;

public interface StudentService_Mapper {

	//학생 회원가입
	public int studentJoin(HashMap<String,Object> hm);
	
	//학생 아이디 중복 체크
	public int studentIdChcek(HashMap<String,String> hm);
}
