//211027 jhr �۾�
package com.onclick.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

	@RequestMapping(value="/lecEvaluation.do")
	public String videoLevelUpdate( @RequestParam("vidx") int vidx,
									Model model) {
		//���ǳ��̵� �ۼ������� �ҷ����� 
		model.addAttribute("vidx", vidx);
		
		return "lecture/lecEvaluation";
	}
	
	@RequestMapping(value="/lecEvaluationAction.do")
	public String videoLevelUpdateAction(@RequestParam("vlevel") int vlevel,
										 @RequestParam("vidx") int vidx) {
		//������ ��û�� ���ǳ��̵� ���� 
		int result = vs.videoLevelUpdate(vlevel, vidx);
		
		return "lecture/lecEvaluationSuc";
	}


	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(@RequestParam("result") String result, VideoAttenDto vd, HttpSession session) {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		//��ü�ð�,���۽ð�,����ð� �޾ƿ�
		vd.setSidx((Integer)session.getAttribute("sidx"));
		int cnt;
		if(result.equals("Y")) {
			cnt=vs.videoUpdate(vd);			
		}else {//�⼮�Ⱓ ���� ���ǿ� ���� ����ð��� ���ε���
			cnt=vs.videoUpdateAfter(vd);
		}

		return cnt;
	}

	@RequestMapping(value="/stuLecContent.do")
	public String stuLecContent(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model,HttpSession session) {
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
	
	@RequestMapping(value="/stuLecRe.do")
	public String stuLecRe(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model,HttpSession session) {
		//�л� ������ �⼮ ȭ��
		//��������
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
		int lidx = cv.getLidx();
			
		//���� ��û��� 
		VideoAttenDto vd = vs.videoSelectOne(sidx, cidx);
		model.addAttribute("vd", vd);
		
		return "lecture/stuLecRe";
	}
	
	@RequestMapping(value="/proLecContent.do")
	public String proLecContent(@RequestParam("pidx") int pidx, @RequestParam("cidx") int cidx, Model model) {
		//���� ������ �⼮ ȭ��
		//��������
		ClassVo cv = cs.classSelectOne(cidx);
		model.addAttribute("cv", cv);
	
		return "lecture/proLecContent";
	}
	
}
