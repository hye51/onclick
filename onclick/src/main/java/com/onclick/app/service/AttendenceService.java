//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.VideoDTO;

public interface AttendenceService {

	//�л� �⼮ ���� �������� - ������
	public ArrayList<VideoDTO> stuVideoAttend(int lidx, int sidx);
	
	//�л� �⼮ ���� �������� - �ǽð�
	public ArrayList<AttendenceDTO> stuLiveAttend(int lidx, int sidx);
	
	//���� ��ü �⼮ ���� �������� - ������(������)
//	public ArrayList<VideoDTO> proVideoAttend(int lidx, int cweek);
	public ArrayList<VideoDTO> proVideoAttend(int cidx, int cidx2, int cidx3);
	
	//���� ��ü �⼮ ���� �������� - �ǽð�(������)
	public ArrayList<AttendenceDTO> proLiveAttend(int lidx, int cweek);
}
