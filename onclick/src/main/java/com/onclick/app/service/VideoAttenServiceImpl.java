//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.persistence.VideoAttenService_Mapper;

@Service("VideoAttenServiceImpl")
public class VideoAttenServiceImpl implements VideoAttenService{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int videoUpdate(VideoAttenDto vd) {
		//���� ��û�� ��û��� ������Ʈ
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("sidx", vd.getSidx());
		hm.put("cidx", vd.getCidx());
		hm.put("vfull", vd.getVfull());
		hm.put("vstart", vd.getVstart());
		hm.put("vend", vd.getVend());
		hm.put("vpercent", vd.getVend()-vd.getVstart());
		
		//������ �⼮ ��� 
		int percent= vd.getVpercent();
		int full = vd.getVfull();

		if(((double) percent / (double) full * 100.0) > 80.0) {
			hm.put("vattendence", "Y");
		}else {
			hm.put("vattendence", "N");
		}
			
		VideoAttenService_Mapper vsm = sqlSession.getMapper(VideoAttenService_Mapper.class);
		int result = vsm.videoUpdate(hm);

		return result;
	}

	@Override
	public VideoAttenDto videoSelectOne(int sidx, int cidx) {
		//���� ��û ��� ��������
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("sidx", sidx);
		hm.put("cidx", cidx);
		
		VideoAttenService_Mapper vsm = sqlSession.getMapper(VideoAttenService_Mapper.class);
		VideoAttenDto vd = vsm.videoSelectOne(hm);
		
		return vd;
	}

	@Override
	public ArrayList<VideoAttenDto> stuAttendence(int sidx) {
		//�л� ���º� ������Ȳ
		VideoAttenService_Mapper vsm = sqlSession.getMapper(VideoAttenService_Mapper.class);
		ArrayList<VideoAttenDto> stuAttList = vsm.stuAttendence(sidx);
		
		return stuAttList;
	}

	@Override
	public int videoUpdateAfter(VideoAttenDto vd) {
		//���� ��û ��� ������Ʈ(�⼮�Ⱓ ���� ���ǿ� ����)
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("sidx", vd.getSidx());
		hm.put("cidx", vd.getCidx());
		hm.put("vend", vd.getVend());

		VideoAttenService_Mapper vsm = sqlSession.getMapper(VideoAttenService_Mapper.class);
		int result =vsm.videoUpdateAfter(hm);
		
		return result;
	}
	
	
}
