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
		//���� ���ε� �˸� 
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
	public int alarmTaskInsert(int lidx,int tuidx,String pname) {
		//���� ���ε� �˸� 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("ncontents", "���ο� ������ ���ε� �Ǿ����ϴ�.");
		hm.put("nwriter", pname);
		hm.put("lidx", lidx);
		hm.put("tuidx",tuidx);
		
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmTaskInsert(hm);
		
		return result;
	}

	@Override
	public int alarmNoticeInsert(int lidx,int lnidx, String pname) {
		//�������� ���ε� �˸� 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("ncontents", "���ο� ���������� ���ε� �Ǿ����ϴ�.");
		hm.put("nwriter", pname);
		hm.put("lidx", lidx);
		hm.put("lnidx",lnidx);
		
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmNoticeInsert(hm);
				
		return result;
	}

	@Override
	public ArrayList<NoticeVO> alarmList(int sidx) {
		//�˸� ��ȸ 
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		ArrayList<NoticeVO> alarm = nsm.alarmList(sidx);
		
		//�˸� ���� 
		
		return alarm;
	}

	@Override
	public int alarmUpdate(int nidx) {
		//�˸� ���� �������� ����
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmUpdate(nidx);
		
		return result;
	}

	@Override
	public int alarmClassDelete(int cidx) {
		//���� ������ �˸�����
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmClassDelete(cidx);
		
		return result;
	}

	@Override
	public int alarmTaskDelete(int tuidx) {
		//���� ������ �˸�����
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmTaskDelete(tuidx);
		
		return result;
	}

	@Override
	public int alarmNoticeDelete(int lnidx) {
		//�������� ������ �˸�����
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmNoticeDelete(lnidx);
		
		return result;
	}

}
