//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService {


	//���� ��û�� ��û��� ������Ʈ
	public int videoUpdate(VideoAttenDto vd);
	
	//���� ��û ��� ������Ʈ(�⼮�Ⱓ ���� ���ǿ� ����)
	public int videoUpdateAfter(VideoAttenDto vd);
	
	//���� ��û ��� ��������
	public VideoAttenDto videoSelectOne(int sidx, int cidx);
	
	//�л� ���º� ������Ȳ
	public ArrayList<VideoAttenDto> stuAttendence(int sidx);
	
	//���� ��
	public int videoLevelUpdate(int vlevel, int vidx);
}
