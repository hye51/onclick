package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.FileVO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.TaskService_Mapper;

@Service("fileServiceImpl")
public class FileServiceImpl implements FileService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public FileVO fileSelectAll(int fidx) {
		//���� ���� ���
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		FileVO fv = fsm.fileSelectAll(fidx);
		
		return fv;
	}

	@Override
	public HashMap<String, Object> fileDownload(int fidx) {
		//���� ���� �ٿ�ε�
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		HashMap<String, Object> hm = fsm.fileDownload(fidx);
		return hm;
	}

	@Override
	public int fileDelete(int fidx) {
		//���� ����
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value = fsm.fileDelete(fidx);
		return value;
	}

}
