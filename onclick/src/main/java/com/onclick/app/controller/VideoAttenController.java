//211027 jhr �۾�
package com.onclick.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.ClassService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.VideoAttenService;

@Controller
public class VideoAttenController {
	
	@Autowired
	VideoAttenService vs;
	
	@Autowired
	ClassService cs;
	
	@Autowired
	LecService ls;
	
	/*
	
	@RequestMapping(value="/.do")
	public String videoContents() {
		//��û��� ��ư ������ ���
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoLevelUpdate() {
		//������ ��û�� ���ǳ��̵� �ۼ�
		return null;
	}
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(VideoAttenDto vd, HttpSession session) {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		//��ü�ð�,���۽ð�,����ð� �޾ƿ�
		vd.setSidx((Integer)session.getAttribute("sidx"));
		System.out.println("��û������Ʈvd.getVpercent()  : " +vd.getVpercent() );
		int result=vs.videoUpdate(vd);
		System.out.println("��û������Ʈ ��  : " +result );
		return result;
	}
	
	/*
	@RequestMapping(value="/.do")
	public String videoStart() {
		//��û���� ��ư ���� ���
		return null;
	}

	 */

	@RequestMapping(value="/stuLecContent.do")
	public String lecContent(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model,HttpSession session) {
		//�л� ������ �⼮ ȭ��
		//��������
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
		int lidx = cv.getLidx();
		
		//�ش� ���� ���� ��������(�˸����� �Ѿ�� ���)
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
				
		//���� ��û��� 
		VideoAttenDto vd = vs.videoSelectOne(sidx, cidx);
		model.addAttribute("vd", vd);

		return "lecture/stuLecContent";
	}
	
	
	@RequestMapping(value="/proLecContent.do")
	public String videoProAtten(@RequestParam("pidx") int pidx, @RequestParam("cidx") int cidx, Model model) {
		//���� ������ �⼮ ȭ��
		//��������
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
		
		
		return "lecture/proLecContent";
	}
	
}
