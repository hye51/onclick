package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.ProfessorVO;
import com.onclick.app.persistence.ProfessorService_Mapper;
import com.onclick.app.persistence.StudentService_Mapper;

@Service("professorServiceImpl")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int professorIdCheck(String pidx) {
		//���� ���̵� �ߺ� üũ
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("pidx", pidx);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.professorIdCheck(hm);
		
		return cnt;
	}

	@Override
	public int professorJoin(int pidx, String pname, String ppwd, int pphone, String pemail) {
		//���� ȸ������
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("pidx", pidx);
		hm.put("pname", pname);
		hm.put("ppwd", ppwd);
		hm.put("pphone",pphone);
		hm.put("pemail", pemail);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.professorJoin(hm);
		
		return cnt;
	}

	@Override
	public ProfessorVO professorLogin(int pidx, String ppwd) {
		//���� �α��� 
		HashMap<String, Object> hm = new HashMap<String,Object>();
		hm.put("pidx", pidx);
		hm.put("ppwd", ppwd);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		ProfessorVO pv  = psm.professorLogin(hm);
		
		return pv;
	}

	@Override
	public int proPwdCheck(String ppwd) {
		//���� ��й�ȣ Ȯ��
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("ppwd", ppwd);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.proPwdCheck(hm);

		return cnt;
	}
	
	@Override
	public int professorModifyAction(int pidx, String ppwd) {
		//���� ���� ���� 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("pidx", pidx);
		hm.put("ppwd", ppwd);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.professorModifyAction(hm);
		
		return cnt;
	}
	
	@Override
	public ProfessorVO proInfo(int pidx) {
		//���� ���� ���� 
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		ProfessorVO pv  = psm.proInfo(pidx);
		
		return pv;
	}
}
