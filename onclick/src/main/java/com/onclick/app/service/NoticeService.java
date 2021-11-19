package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.NoticeVO;

public interface NoticeService {

	//강좌 업로드 알림 
	public int alarmClassInsert(int lidx,int cidx,String pname);
	
	//과제 업로드 알림 
	public int alarmTaskInsert(int lidx, String pname);
	
	//공지사항 업로드 알림 
	public int alarmNoticeInsert(int lidx, String pname);
	
	//알림 조회 
	public ArrayList<NoticeVO> alarmList(int sidx);
	
}
