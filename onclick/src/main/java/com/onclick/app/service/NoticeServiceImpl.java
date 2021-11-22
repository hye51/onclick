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
		//강좌 업로드시 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("ncontents", "새로운 강의가 업로드 되었습니다.");
		hm.put("nwriter", pname);
		hm.put("lidx", lidx);
		hm.put("cidx", cidx);
		
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		int result=nsm.alarmClassInsert(hm);
		
		return result;
	}

	@Override
	public int alarmTaskInsert(int lidx, String pname) {
		//과제 업로드 알림 
		return 0;
	}

	@Override
	public int alarmNoticeInsert(int lidx, String pname) {
		//공지사항 업로드 알림 
		return 0;
	}

	@Override
	public ArrayList<NoticeVO> alarmList(int sidx) {
		//알림 조회 
		NoticeService_Mapper nsm = sqlSession.getMapper(NoticeService_Mapper.class);
		ArrayList<NoticeVO> alarm = nsm.alarmList(sidx);
		
		//알림 개수 
		
		return alarm;
	}

}
