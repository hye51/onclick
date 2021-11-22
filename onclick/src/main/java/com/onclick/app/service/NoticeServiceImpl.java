package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.NoticeVO;
import com.onclick.app.persistence.NoticeService_Mapper;

@Service("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int alarmClassInsert(int lidx,int cidx,String pname) {
		//���� ���ε�� 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("ncontents", "���ο� ���ǰ� ���ε� �Ǿ����ϴ�.");
		hm.put("nwriter", pname);
		hm.put("lidx", lidx);
		hm.put("cidx", cidx);
		
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmClassInsert(hm);
		
		return result;
	}

	@Override
	public int alarmTaskInsert(int lidx, String pname) {
		//���� ���ε� �˸� 
		return 0;
	}

	@Override
	public int alarmNoticeInsert(int lidx, String pname) {
		//�������� ���ε� �˸� 
		return 0;
	}

	@Override
	public ArrayList<NoticeVO> alarmList(int sidx) {
		//�˸� ��ȸ 
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		ArrayList<NoticeVO> alarm = nsm.alarmList(sidx);
		
		//�˸� ���� 
		
		return alarm;
	}

}
