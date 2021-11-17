//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.persistence.EnrollService_Mapper;

@Service("EnrollServiceImpl")
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<Integer> enrollStuList(int lidx) {
		//���ǿ� ���� �л� ����Ʈ 
		EnrollService_Mapper esm = sqlSession.getMapper(EnrollService_Mapper.class);
		ArrayList<Integer> stuList = esm.enrollStuList(lidx);
		System.out.println(stuList + "*********************");
		return stuList;
	}

}
