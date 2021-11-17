//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.persistence.ClassService_Mapper;

@Service("classServiceImpl")
public class ClassServiceImpl implements ClassService{

	@Autowired
	SqlSession sqlSession;
	
	@Transactional
	@Override
	public int classInsert(ClassVo cv) {
		//���� ���ε�
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		hm.put("creyn", cv.getCreyn());
		hm.put("cnotyn", cv.getCnotyn());
		hm.put("lidx", cv.getLidx());
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classInsert(hm);
		//insert �� cidx �� �޾ƿ;��� 
		int cidx = Integer.parseInt(String.valueOf(hm.get("cidx")));
		System.out.println("cidx  : " + cidx);
		return result;
	}

	@Override
	public ArrayList<ClassVo> classSelect(int lidx){
		//���� ����Ʈ
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> alist = csm.classSelect(lidx);
		
		return alist;
	}
	

}
