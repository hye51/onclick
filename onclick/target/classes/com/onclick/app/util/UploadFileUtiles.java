package com.onclick.app.util;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtiles {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtiles.class);
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		//���ϸ� ��ġ�� �ʵ��� 
		UUID uid = UUID.randomUUID();
		//���� ���� �̸��� UUID ����
		String savedName = uid.toString() + "_"+ originalName;
		//������ ���� �غ�
		File target = new File(uploadPath, savedName);
		//��������
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	
}
