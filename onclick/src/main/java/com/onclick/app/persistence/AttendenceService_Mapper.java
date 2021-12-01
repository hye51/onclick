package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.VideoDTO;

public interface AttendenceService_Mapper {

	//�л� �⼮ ���� �������� - ������
	public ArrayList<VideoDTO> stuVideoAttend(int lidx, int sidx);

	//�л� �⼮ ���� �������� - �ǽð�
	public ArrayList<AttendenceDTO> stuLiveAttend(int lidx, int sidx);
	
	//���� ��ü �⼮ ���� �������� - ������(������)
	//public ArrayList<VideoDTO> proVideoAttend(int lidx, int cweek);
	public ArrayList<VideoDTO> proVideoAttend2(int cidx, int cidx2, int cidx3);
	
	//���� ��ü �⼮ ���� �������� - �ǽð�(������)
	public ArrayList<AttendenceDTO> proLiveAttend(int lidx, int cweek);
}
