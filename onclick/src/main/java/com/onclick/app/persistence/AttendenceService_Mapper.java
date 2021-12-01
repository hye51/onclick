package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.VideoDTO;

public interface AttendenceService_Mapper {

	//학생 출석 정보 가져오기 - 동영상
	public ArrayList<VideoDTO> stuVideoAttend(int lidx, int sidx);

	//학생 출석 정보 가져오기 - 실시간
	public ArrayList<AttendenceDTO> stuLiveAttend(int lidx, int sidx);
	
	//교수 전체 출석 정보 가져오기 - 동영상(주차별)
	//public ArrayList<VideoDTO> proVideoAttend(int lidx, int cweek);
	public ArrayList<VideoDTO> proVideoAttend2(int cidx, int cidx2, int cidx3);
	
	//교수 전체 출석 정보 가져오기 - 실시간(주차별)
	public ArrayList<AttendenceDTO> proLiveAttend(int lidx, int cweek);
}
