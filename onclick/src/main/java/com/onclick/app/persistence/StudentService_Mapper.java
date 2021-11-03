package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;

public interface StudentService_Mapper {

	//학생 회원가입
	public int studentJoin(HashMap<String,Object> hm);
	
	//학생 아이디 중복 체크
	public int studentIdChcek(HashMap<String,String> hm);
	
	//학생로그인
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	//학생과목
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	//강의홈
	public LecVO stuLecHome(int lidx);
	
}
