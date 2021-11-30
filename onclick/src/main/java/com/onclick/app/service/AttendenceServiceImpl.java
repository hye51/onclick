//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.AttendenceDTO;
import com.onclick.app.domain.VideoDTO;
import com.onclick.app.persistence.AttendenceService_Mapper;

@Service("attendenceServiceImpl")
public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<VideoDTO> stuVideoAttend(int lidx, int sidx) {
		//학생 동영상 출석 정보 가져오기
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<VideoDTO> vlist = asm.stuVideoAttend(lidx, sidx);
		
		return vlist;
	}

	@Override
	public ArrayList<AttendenceDTO> stuLiveAttend(int lidx, int sidx) {
		//학생 실시간 출석 정보 가져오기
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<AttendenceDTO> alist = asm.stuLiveAttend(lidx, sidx);
		
		return alist;
	}

	@Override
	public ArrayList<VideoDTO> proVideoAttend(int lidx, int cweek) {
		//교수 전체 출석 정보 가져오기 - 동영상(주차별)
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<VideoDTO> vlist = asm.proVideoAttend(lidx, cweek);
		
		return vlist;
	}

}
