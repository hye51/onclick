package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService_Mapper {
	
	//�⺻�� �Է� 
	public int videoInsert();

	//���� ��û�� ��û��� ������Ʈ
	public int videoUpdate(HashMap<String,Object> hm);
	
	//���� ��û�� ��û��� ������Ʈ
	public int videoUpdateAfter(HashMap<String,Object> hm);
		
	//���� ��û ��� ��������
	public VideoAttenDto videoSelectOne(HashMap<String,Object> hm);
	
	//�л� ���º� ������Ȳ
	public ArrayList<VideoAttenDto> stuAttendence(int sidx);
	
}
