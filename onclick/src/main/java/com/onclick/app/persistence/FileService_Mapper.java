package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.FileVO;

public interface FileService_Mapper {

	//÷������ ��������
	public FileVO fileSelectAll(int fidx);
	
	//÷������ �ٿ�ε�
	public HashMap<String, Object> fileDownload(int fidx);
	
	//���� ����
	public int fileDelete(int fidx);
}
