//211027 jhr 작업
package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.persistence.ClassService_Mapper;

@Service("classServiceImpl")
public class ClassServiceImpl implements ClassService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int classInsert(ClassVo cv) {
		//강좌 업로드
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classInsert(hm);
		
		return result;
	}

}
