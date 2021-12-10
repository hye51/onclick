package com.onclick.app.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	FileService fs;

	@RequestMapping(value="/fileDownload.do")
	public void fileDownload(@RequestParam("fidx") int fidx,HttpServletResponse response) throws Exception{
		//파일 다운로드
		HashMap<String,Object> fileDown = fs.fileDownload(fidx);
		String savedName = (String)fileDown.get("FSAVEDNAME");
		String originName = (String)fileDown.get("FORIGINNAME");
		
		//파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:/image/uploadFile"+savedName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		return;
	}
	


}
