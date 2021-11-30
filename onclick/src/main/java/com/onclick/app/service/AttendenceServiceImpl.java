//211027 jhr �۾�
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
		//�л� ������ �⼮ ���� ��������
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<VideoDTO> vlist = asm.stuVideoAttend(lidx, sidx);
		
		return vlist;
	}

	@Override
	public ArrayList<AttendenceDTO> stuLiveAttend(int lidx, int sidx) {
		//�л� �ǽð� �⼮ ���� ��������
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<AttendenceDTO> alist = asm.stuLiveAttend(lidx, sidx);
		
		return alist;
	}

	@Override
	public ArrayList<VideoDTO> proVideoAttend(int lidx, int cweek) {
		//���� ��ü �⼮ ���� �������� - ������(������)
		AttendenceService_Mapper asm = sqlSession.getMapper(AttendenceService_Mapper.class);
		ArrayList<VideoDTO> vlist = asm.proVideoAttend(lidx, cweek);
		
		return vlist;
	}

}
