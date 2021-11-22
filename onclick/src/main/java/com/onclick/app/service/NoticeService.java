package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.NoticeVO;

public interface NoticeService {

	//���� ���ε� �˸� 
	public int alarmClassInsert(int lidx,int cidx,String pname);
	
	//���� ���ε� �˸� 
	public int alarmTaskInsert(int lidx, String pname);
	
	//�������� ���ε� �˸� 
	public int alarmNoticeInsert(int lidx, String pname);
	
	//�˸� ��ȸ 
	public ArrayList<NoticeVO> alarmList(int sidx);
	
	//�˸� ���� �������� ����
	public int alarmUpdate(int nidx); 
	
	
}
