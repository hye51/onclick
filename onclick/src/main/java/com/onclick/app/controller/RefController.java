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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.RefVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.RefService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class RefController { //�ڷ� ��Ʈ�ѷ�
	
	@Autowired
	RefService rs;
	
	@Autowired
	FileService fs;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/refWrite.do")
	public String refWrite() {
		//�ڷ� �ۼ� ȭ��
		return "lecture/refUpload";
	}
	
	
	@RequestMapping(value="/refWriteAction.do")
	public String refWriteAction(@RequestParam("lidx") int lidx,
								@RequestParam("refSubject") String rname,
								@RequestParam("refContents") String rcontents,
								@RequestParam("refFile") MultipartFile rfile) throws Exception {
		//�ڷ� �ۼ� �Ϸ�
		String str = null;
		
		if(rfile.isEmpty()) { // ÷������ ���� ��� 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("lidx", lidx);
			hm.put("fidx", "");
			
			int value = rs.refInsert(hm);
			//insert�� ���� �������� �ε��� �޾ƿ���
			int ridx = Integer.parseInt(String.valueOf(hm.get("ridx")));
			
			if(value == 1) { //insert ����
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refWrite.do";
			}
			
		} else { //÷������ �ִ� ���
			
			//÷������ ����
			//���ϸ�
			String originalFileName = rfile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			//����� �̸�
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, rfile.getBytes());
			
			HashMap<String, Object> refFile = new HashMap<String, Object>();
			refFile.put("originName", originalFileName);
			refFile.put("savedName", savedName);
			refFile.put("originalFileExtension", originalFileExtension);
			refFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("lidx", lidx);
			
			int value = rs.refAndFileInsert(hm, refFile);
			//insert�� ���� �������� �ε��� �޾ƿ���
			int ridx = Integer.parseInt(String.valueOf(hm.get("ridx")));
			
			if(value == 2) { //insert ����
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refWrite.do";
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/refList.do")
	public String refList(@RequestParam("lidx") int lidx, Model model) {
		//�ڷ� ���
		ArrayList<RefVO> rlist = rs.refSelectAll(lidx);
		model.addAttribute("rlist", rlist);
		
		return "lecture/refList";
	}
	
	
	@RequestMapping(value="/refContent.do")
	public String refContents(@RequestParam("ridx") int ridx, HttpSession session) {
		//�ڷ� ���뺸��
		RefVO rv = rs.refSelectOne(ridx);
		session.setAttribute("rv", rv);
		
		//���� �ε��� �ִ� ��� FileVO ���ǿ� ���
		if((Integer)rv.getFidx() != null) {
			FileVO fv = fs.fileSelectAll(rv.getFidx());
			session.setAttribute("fv", fv);
		}
		return "lecture/refContent";
	}
	
	
	@RequestMapping(value="/refModify.do")
	public String refModify(@RequestParam("ridx") int ridx, HttpSession session) {
		//�ڷ� ���� ȭ��
		RefVO rv = rs.refSelectOne(ridx);
		session.setAttribute("rv", rv);
		
		return "lecture/refModify";
	}
	
	
	@RequestMapping(value="/refModifyAction.do")
	public String refModifyAction(@RequestParam("ridx") int ridx,
			@RequestParam("refSubject") String rname,
			@RequestParam("refContents") String rcontents,
			@RequestParam("refFile") MultipartFile rfile) throws Exception {
		//�ڷ� ���� �Ϸ�
		String str = null;
		
		if(rfile.isEmpty()) { // ÷������ ���� X 
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("ridx", ridx);
			
			int value = rs.refModify(hm);
			
			if(value == 1) { //insert ����
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refModify.do?ridx="+ridx;
			}
			
		} else { //÷������ ���� O
			
			//���ο� ÷������ ����
			//���ϸ�
			String originalFileName = rfile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			//����� �̸�
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, rfile.getBytes());
			
			HashMap<String, Object> refFile = new HashMap<String, Object>();
			refFile.put("originName", originalFileName);
			refFile.put("savedName", savedName);
			refFile.put("originalFileExtension", originalFileExtension);
			refFile.put("route", route);
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("rname", rname);
			hm.put("rcontents", rcontents);
			hm.put("ridx", ridx);
			
			int value = rs.refAndFileModify(hm, refFile);
			
			if(value == 2) { //insert ����
				str="redirect:/refContent.do?ridx="+ridx;
			} else {
				str="redirect:/refModify.do?ridx="+ridx;
			}
		}
		
		return str;
	}
	
	@RequestMapping(value="/refDeleteAction.do")
	public String refDelete(HttpSession session, RedirectAttributes rttr) {
		//�ڷ� ���� 
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx();
		RefVO rv = (RefVO)session.getAttribute("rv");
		int ridx = rv.getRidx(); 		
				
		int value = rs.refDelete(ridx);
		
		String str = null;				
				
		if(value == 1) {
			rttr.addFlashAttribute("msg", "�����Ǿ����ϴ�.");
			str="redirect:/refList.do?lidx="+lidx;
		} else {
			str="redirect:/refContent.do?ridx="+ridx;
		}
		
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/rExFileDelete.do")
	public HashMap<String,Object> rExFileDelete(@RequestParam("fidx") int fidx,
										@RequestParam("ridx") int ridx) {
		//�������������� ���� ������ư ������ ��(ajax)
		int value = rs.rExFileDelete(ridx, fidx);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
