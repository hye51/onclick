//211027 jhr 작업
package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.persistence.StudentService_Mapper;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail) {
		//학생 가입
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("sidx", sidx);
		hm.put("spwd", spwd);
		hm.put("sname", sname);
		hm.put("sphone", sphone);
		hm.put("semail", semail);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentJoin(hm);

		return 0;
	}

	@Override
	public int studentIdChcek(String sidx) {
		//학생 아이디 중복 체크
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("sidx", sidx);
	
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentIdChcek(hm);
		
		return cnt;
	}

	



}
