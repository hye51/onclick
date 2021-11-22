package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.NoticeVO;

public interface NoticeService_Mapper {

	//���� ���ε� �˸� 
	public int alarmClassInsert(HashMap<String,Object> hm);
	
	//���� ���ε� �˸� 
	public int alarmTaskInsert(HashMap<String,Object> hm);
	
	//�������� ���ε� �˸� 
	public int alarmNoticeInsert(HashMap<String,Object> hm);
	
	//�˸� ��ȸ 
	public ArrayList<NoticeVO> alarmList(int sidx);
	
	//�˸� ���� �������� ����
	public int alarmUpdate(int nidx); 
	
}
