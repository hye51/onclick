package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.NoticeVO;

public interface NoticeService_Mapper {

	//강좌 업로드 알림 
	public int alarmClassInsert(HashMap<String,Object> hm);
	
	//과제 업로드 알림 
	public int alarmTaskInsert(HashMap<String,Object> hm);
	
	//공지사항 업로드 알림 
	public int alarmNoticeInsert(HashMap<String,Object> hm);
	
	//알림 조회 
	public ArrayList<NoticeVO> alarmList(int sidx);
	
	//알림 상태 읽음으로 변경
	public int alarmUpdate(int nidx); 
	
}
