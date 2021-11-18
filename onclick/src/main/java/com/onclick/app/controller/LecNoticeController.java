package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class LecNoticeController { //���� �������� ��Ʈ�ѷ�

	@Autowired
	LecNoticeService lns;

	@Autowired
	FileService fs;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/noticeList.do")
	public String lecNoticeList(@RequestParam("lidx") String lidx, Model model) {
		//���� �������� ���
		ArrayList<LecNoticeVO> lnList = lns.lecNoticeSelectAll(Integer.parseInt(lidx));		
		model.addAttribute("lnList", lnList);
		
		return "lecture/noticeList";
	}
	
	@RequestMapping(value="/lecNoticeContent.do")
	public String lecNoticeContents(@RequestParam("lnidx") int lnidx,
									HttpSession session) {
		//���� �������� ���뺸��
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		if((Integer)lnv.getFidx() != null) {
			FileVO fv = fs.fileSelectAll(lnv.getFidx());
			session.setAttribute("fv", fv);
		}
		
		return "lecture/noticeContent";
	}
	
	
	@RequestMapping(value="/lecNoticeWrite.do")
	public String lecNoticeWrite() {
		//���� �������� �ۼ� ȭ��
		return "lecture/noticeUpload";
	}

	@RequestMapping(value="/lecNoticeWriteAction.do")
	public String lecNoticeWriteAction(@RequestParam("lecNotSubject") String lnsubject,
										@RequestParam("lecNotContents") String lncontents,
										@RequestParam("lecNotFile") MultipartFile lnfile,
										HttpSession session) throws Exception {
		//���� �������� �ۼ� �Ϸ�
		System.out.println("�������� �ۼ��Ϸ�");
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		String str = null;
		
		if(lnfile.isEmpty()) { // ÷������ ���� ��� 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lidx", lidx);
			hm.put("fidx", 0);
			
			int value = lns.lecNoticeInsert(hm);
			int lnidx = Integer.parseInt(String.valueOf(hm.get("lnidx")));
			
			if(value == 1) {
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNoticeWrite.do";
			}
			
		} else { //÷������ �ִ� ���
			
			//÷������ ����
			//���ϸ�
			String originalFileName = lnfile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, lnfile.getBytes());
			
			HashMap<String, Object> lecNoticeFile = new HashMap<String, Object>();
			lecNoticeFile.put("originName", originalFileName);
			lecNoticeFile.put("savedName", savedName);
			lecNoticeFile.put("originalFileExtension", originalFileExtension);
			lecNoticeFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lidx", lidx);
			
			int value = lns.lecNoticeAndFileInsert(hm, lecNoticeFile);
			int lnidx = Integer.parseInt(String.valueOf(hm.get("lnidx")));
			
			if(value == 2) {
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNoticeWrite.do";
			}
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/lecNotModify.do")
	public String lecNoticeModify(@RequestParam("lnidx") int lnidx, HttpSession session) {
		//�������� ����
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		return "lecture/noticeModify";
	}
	
	@RequestMapping(value="/lecNotModifyAction.do")
	public String lecNoticeModifyAction(@RequestParam("lecNotSubject") String lnsubject,
									@RequestParam("lecNotContents") String lncontents,
									@RequestParam("lecNotFile") MultipartFile lnfile,
									@RequestParam("lnidx") int lnidx,
									HttpSession session) throws Exception {
		//�������� ���� �Ϸ�
		String str = null;
		
		if(lnfile.isEmpty()) { // ÷������ ���� ��� 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lnidx", lnidx);
			hm.put("fidx", "");
			
			int value = lns.lecNotModify(hm);
			
			if(value == 1) {
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNotModify.do?lnidx="+lnidx;
			}
			
		} else { //÷������ �ִ� ���
			
			//÷������ ����
			//���ϸ�
			String originalFileName = lnfile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, lnfile.getBytes());
			
			HashMap<String, Object> lecNoticeFile = new HashMap<String, Object>();
			lecNoticeFile.put("originName", originalFileName);
			lecNoticeFile.put("savedName", savedName);
			lecNoticeFile.put("originalFileExtension", originalFileExtension);
			lecNoticeFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("lnsubject", lnsubject);
			hm.put("lncontents", lncontents);
			hm.put("lnidx", lnidx);
			
			int value = lns.lecNotAndFileModify(hm, lecNoticeFile);
			
			if(value == 2) {
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			} else {
				str="redirect:/lecNotModify.do?lnidx="+lnidx;
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/lecNotDeleteAction.do")
	public String lecNoticeDelete(HttpSession session) {
		//�������� ����
		
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		LecNoticeVO lnv = (LecNoticeVO)session.getAttribute("lnv");
		int lnidx = lnv.getLnidx();
		
		String str = "";
		
		
		if(lnv.getFidx() != 0) { //���� ���� ��� ���ϵ� ���� ����
			int fidx = lnv.getFidx();
			int value = lns.lecNotAndFileDelete(lnidx, fidx);
			
			if(value==2) {
				str="redirect:/noticeList.do?lidx="+lidx;
			} else {
				str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			}
			
		} else { //���� ���� ��� ������ ����
			int value = lns.lecNoticeDelete(lnidx);
			
			if(value==1) {
				str="redirect:/noticeList.do?lidx="+lidx;
			} else {
			str="redirect:/lecNoticeContent.do?lnidx="+lnidx;
			}
		}
		
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="/lnExFileDelete.do")
	public HashMap<String,Object> lnExFileDelete(@RequestParam("fidx") int fidx,
										@RequestParam("lnidx") int lnidx) {
		//�������������� ���� ������ư ������ ��(ajax)
		int value = lns.lnExFileDelete(lnidx, fidx);
		
		System.out.println("lnexdel:"+value);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
