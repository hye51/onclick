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

import com.onclick.app.domain.Criteria;
import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.PageMaker;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.NoticeService;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.StudentService;
import com.onclick.app.service.TaskService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class TaskController { //���� ���� ��Ʈ�ѷ�

	@Autowired
	TaskService ts;
	
	@Autowired
	LecService ls;
	
	@Autowired
	FileService fs;
	
	@Autowired
	S_taskService sts;
	
	@Autowired
	PageMaker pm;
	
	@Autowired
	NoticeService ns;
	
	@Autowired
	StudentService ss;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@RequestMapping(value="/taskContent.do")
	public String taskContent(@RequestParam("tuidx") int tuidx,
						@RequestParam("lidx") int lidx,
						Model model, HttpSession session) {
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//���� �̸� ��������
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//���� ������� ���� ���̺��� ���� ��� �������� 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		//��ú��� ���� ��Ͽ��� ���� ���뺸��� �Ѿ��
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		//�ش� ���� ���� ��������
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		
		//÷������ ��������
		FileVO fv = fs.fileSelectAll(tv.getFidx());
		if(fv != null) {
			session.setAttribute("fv", fv);
			System.out.println("fv:"+fv);
		}
		
		if(session.getAttribute("sidx") != null) {
			int sidx = (Integer)session.getAttribute("sidx");
			S_taskDTO std = sts.s_taskCheck(sidx, tuidx);
			session.setAttribute("std", std);
			System.out.println("std:"+std);
		}
		
		return "lecture/taskContent";
	}

	@RequestMapping(value="/taskList.do")
	public String taskList(@RequestParam("lidx") int lidx, 
			Criteria cri, Model model, HttpSession session) {
		
		if(session.getAttribute("sidx")!=null && session.getAttribute("pidx")==null) {
			int sidx = (Integer)session.getAttribute("sidx");
			//���� �̸� ��������
			ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(sidx);
			model.addAttribute("stuLecList", stuLecList);
		} else if(session.getAttribute("sidx")==null && session.getAttribute("pidx")!=null) {
			int pidx = (Integer)session.getAttribute("pidx");
			//���� ������� ���� ���̺��� ���� ��� �������� 
			ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
			model.addAttribute("alist", alist);
		}
		
		//����¡ ó��
		//���� ��ü ����
		int taskTC = ts.taskTotalCount(lidx);		
		
		int page = cri.getPage();
		int perPageNum = cri.getPerPageNum();
		
		int start = (page-1)*(perPageNum)+1;
		int end = page * perPageNum;
		
				
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("lidx", lidx);
		hm.put("start", start);
		hm.put("end", end);
		
		//������ ���ε��� ���� ���
		ArrayList<TaskVO> tlist = ts.taskSelectAll(hm);
		
		pm.setCri(cri);
		pm.setTotalCount(taskTC);
		
		model.addAttribute("tlist", tlist);
		model.addAttribute("pm", pm);
		
		//�ش� ���� ���� ��������
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		
		
		if(session.getAttribute("sidx") != null) { //�л��� �α��� ���� ��� ������� �Ѿ ��
			int sidx = (Integer)session.getAttribute("sidx");
			
			//�л� ���� ���� ���ǿ� ���
			ArrayList<S_taskDTO> stlist = sts.stuTask(sidx);
			session.setAttribute("stlist", stlist);
		}
	
		return "lecture/taskList";
	}
	
		
	@RequestMapping(value="/taskWrite.do")
	public String taskWrite(HttpSession session, Model model) {
		//���� ���� �ۼ� ȭ��
		int pidx = (Integer)session.getAttribute("pidx");
		//���� ������� ���� ���̺��� ���� ��� �������� 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		return "lecture/taskUpload";
	}
	
	
	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("lidx") int lidx,
			@RequestParam("taskSubject") String tusubject,
			@RequestParam("taskStart") String tustart,
			@RequestParam("taskFin") String tufin,
			@RequestParam("taskContents") String tucontents,
			@RequestParam("taskFile") MultipartFile tufile,
			@RequestParam("taskNotice") String taskNotice,
			HttpSession session) throws Exception{

		String str = null;
		
		if(tufile.isEmpty()) { //÷������ ���� ���
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("lidx", lidx);
			hm.put("tucontents", tucontents);
			
			int value = ts.taskInsert(hm, lidx);
			int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
			
			System.out.println("value:"+value);
			
			if(value == 0) {
				str = "redirect:/taskWrite.do";
			} else {
				if(taskNotice.equals("Y")) {
					//���� ���ε� �˸� 
					String pname= (String)session.getAttribute("pname");
					int cnt = ns.alarmTaskInsert(lidx, tuidx, pname);
				}
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			}
			
		} else {//÷������ �ִ� ���
			
			//÷������ ����
			//���ϸ�
			String originalFileName = tufile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			//����� �̸�
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tufile.getBytes());
			
			HashMap<String, Object> taskFile = new HashMap<String, Object>();
			taskFile.put("originName", originalFileName);
			taskFile.put("savedName", savedName);
			taskFile.put("originalFileExtension", originalFileExtension);
			taskFile.put("route", route);
			
			//���� ���� �ۼ� �Ϸ�
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("lidx", lidx);
			hm.put("tucontents", tucontents);
			
			int value = ts.taskAndFileInsert(hm, taskFile, lidx);
			int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
			
			if(value == 0) {
				str = "redirect:/taskWrite.do";
			} else {
				if(taskNotice.equals("Y")) {
					//���� ���ε� �˸� 
					String pname= (String)session.getAttribute("pname");
					int cnt = ns.alarmTaskInsert(lidx, tuidx, pname);
				}
				
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			}
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/taskModify.do")
	public String taskModify(@RequestParam("tuidx") int tuidx,
			HttpSession session, Model model) {
		
		int pidx = (Integer)session.getAttribute("pidx");
		//���� ������� ���� ���̺��� ���� ��� �������� 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		//���� ���� ���� ȭ��
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		
		if((Integer)tv.getFidx() != null) {
			FileVO fv = fs.fileSelectAll(tv.getFidx());	
			session.setAttribute("fv", fv);
		}
		
		return "lecture/taskModify";
	}
	
	
	@RequestMapping(value="/taskModifyAction.do")
	public String taskModifyAction(@RequestParam("taskSubject") String tusubject,
			@RequestParam("taskStart") String tustart,
			@RequestParam("taskFin") String tufin,
			@RequestParam("taskContents") String tucontents,
			@RequestParam("taskNotice") String tunotyn,
			@RequestParam("taskFile") MultipartFile tufile,
			@RequestParam("tuidx") int tuidx,
			@RequestParam("lidx") int lidx) throws Exception{
		//���� ���� ���� �Ϸ�
		System.out.println("���� ���� ���� �Ϸ�");
		
		String str = null;
		
		if(tufile.isEmpty()) { //÷������ ���� X
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("tucontents", tucontents);
			hm.put("tuidx", tuidx);
			
			//fidx �� ���� ����
			int value = ts.taskModify(hm);
			
			if(value == 1) {
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskModify.do?tuidx="+tuidx+"&lidx="+lidx;
			}
			
		} else {//÷������ ���� O
			
			//���� ���� -> ���ο� ���� ����
			//���ϸ�
			String originalFileName = tufile.getOriginalFilename();
			//���ϸ� �� Ȯ���ڸ� ����
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//���ϰ��
			String route = uploadPath;
			//����� �̸�
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tufile.getBytes());
			
			HashMap<String, Object> taskFile = new HashMap<String, Object>();
			taskFile.put("originName", originalFileName);
			taskFile.put("savedName", savedName);
			taskFile.put("originalFileExtension", originalFileExtension);
			taskFile.put("route", route);
			
			//���� ���� ����
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("tucontents", tucontents);
			hm.put("tuidx", tuidx);
			
			int value = ts.taskAndFileModify(hm, taskFile);
			
			if(value == 2) { //���� insert + ���� ����
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskModify.do?tuidx="+tuidx+"&lidx="+lidx;
			}
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/taskDeleteAction.do")
	public String taskDelete(HttpSession session, RedirectAttributes rttr) {
		//���� ���� ���� -> �л� ���� ���� ����
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx(); 
		TaskVO tv = (TaskVO)session.getAttribute("tv");
		int tuidx = tv.getTuidx();
		
		int value = ts.taskDelete(tuidx);
		
		String str = "";
		
		if(value == 0) {
			str="redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
		} else {
			//������ ������ �ش� �˸� ����
			int result = ns.alarmTaskDelete(tuidx);
			
			rttr.addFlashAttribute("msg", "�����Ǿ����ϴ�.");
			str="redirect:/taskList.do?lidx="+lidx;
		}
		
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/tExFileDelete.do")
	public HashMap<String,Object> fileDelete(@RequestParam("fidx") int fidx,
							@RequestParam("tuidx") int tuidx) {
		//�������������� ���� ���� -ajax�̿�
		int value = ts.tExFileDelete(tuidx, fidx);
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
	
	
	@RequestMapping(value="/taskSubmitList.do")
	public String taskSubmitList(@RequestParam("tuidx") int tuidx, HttpSession session, Model model) {
		
		int pidx = (Integer)session.getAttribute("pidx");
		//���� ������� ���� ���̺��� ���� ��� �������� 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);
		
		//������ ���� �л� ���� ����Ʈ(���� ��Ȳ)
		ArrayList<S_taskDTO> submitList = ts.taskSubmitList(tuidx);
		model.addAttribute("submitList", submitList);
		
		return "lecture/taskSubmitList";
	}
}
