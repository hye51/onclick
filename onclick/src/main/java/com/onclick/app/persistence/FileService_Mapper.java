package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.FileVO;

public interface FileService_Mapper {

	//첨부파일 가져오기
	public FileVO fileSelectAll(int fidx);
	
	//첨부파일 다운로드
	public HashMap<String, Object> fileDownload(int fidx);
	
	//파일 삭제
	public int fileDelete(int fidx);
}
