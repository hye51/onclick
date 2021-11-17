//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.persistence.ClassService_Mapper;
import com.onclick.app.persistence.EnrollService_Mapper;

@Service("classServiceImpl")
public class ClassServiceImpl implements ClassService{

	@Autowired
	SqlSession sqlSession;
	
	@Transactional
	@Override
	public int classInsert(ClassVo cv) {
		//강좌 업로드
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		hm.put("creyn", cv.getCreyn());
		hm.put("cnotyn", cv.getCnotyn());
		hm.put("lidx", cv.getLidx());
		hm.put("cfile", cv.getCfile());
		
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classInsert(hm);

		//insert 후 cidx 값 받아옴
		int cidx = Integer.parseInt(String.valueOf(hm.get("cidx")));

		//강의를 듣는 학생 모두 insert 필요
		//강의에 대한 학생 리스트 
		int cnt = csm.stuVdeio(cidx,cv.getLidx());
		System.out.println("ddddddddd" + cnt);
		return result;
	}

	@Override
	public ArrayList<ClassVo> classSelect(int lidx){
		//강좌 리스트
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> alist = csm.classSelect(lidx);
		
		return alist;
	}

	@Override
	public ClassVo classSelectOne(int cidx) {
		//강좌 내용 불러오기
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ClassVo cv = csm.classSelectOne(cidx);
		
		return cv;
	}
	

}
