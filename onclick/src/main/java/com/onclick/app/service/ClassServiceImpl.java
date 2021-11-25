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
	public HashMap<String,Object> classInsert(ClassVo cv) {
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
		hm.put("cfile", cv.getCfile());
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classInsert(hm);

		//insert�� cidx ��
		int cidx = Integer.parseInt(String.valueOf(hm.get("cidx")));

		//���Ǹ� ��� ����л� insert 
		int cnt = csm.stuVideoDefault(cidx, cv.getLidx());

		HashMap<String,Object> value = new HashMap<String,Object>();
		value.put("result", result);
		value.put("cidx", cidx);
		
		return value;
	}

	@Override
	public ArrayList<ClassVo> classSelect(int lidx){
		//���� ����Ʈ
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> alist = csm.classSelect(lidx);
		
		return alist;
	}

	@Override
	public ClassVo classSelectOne(int cidx) {
		//���� ���� �ҷ�����
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ClassVo cv = csm.classSelectOne(cidx);
		
		return cv;
	}

	@Override
	public int classDelete(int cidx) {
		//���� ����
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result = csm.classDelete(cidx);

		return result;
	}

	@Override
	public int classUpdate(ClassVo cv) {
		//���� ���� ���� 
		HashMap<String,Object> hm = new HashMap<String,Object>();		
		hm.put("cidx", cv.getCidx());
		hm.put("cname", cv.getCname());
		hm.put("ccontents", cv.getCcontents());
		hm.put("csta", cv.getCsta());
		hm.put("cfin", cv.getCfin());
		hm.put("cweek", cv.getCweek());
		hm.put("creyn", cv.getCreyn());
		hm.put("cnotyn", cv.getCnotyn());
		hm.put("cfile", cv.getCfile());
		
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		int result=csm.classUpdate(hm);
		
		return result;
	}

	@Override
	public ArrayList<ClassVo> classFinDash(int lidx) {
		//���� Ȩ ��ú��� - ���� ������ ����(�ش� ���� �ϳ�)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> cdlist = csm.classFinDash(lidx);
		return cdlist;
	}

	@Override
	public ArrayList<ClassVo> classAllFinDash(int sidx) {
		//�л� ��ú��� - ���� ������ ����(���� ��ü)
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> clist = csm.classAllFinDash(sidx);
		return clist;
	}

	@Override
	public ArrayList<ClassVo> lastClassDash(int sidx) {
		//�л� ��ú��� - �ֱ� ������ ����
		ClassService_Mapper csm = sqlSession.getMapper(ClassService_Mapper.class);
		ArrayList<ClassVo> lclist = csm.lastClassDash(sidx);
		return lclist;
	}


}
