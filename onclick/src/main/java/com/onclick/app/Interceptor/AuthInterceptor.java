package com.onclick.app.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// �α��� ���� üũ(���� ��ü �޾ƿ���)
		
		HttpSession session = request.getSession();
		
		System.out.println("���� ���ǿ� ����ִ� ����?" +session.getAttribute("sidx"));
//		System.out.println("���� ���ǿ� ����ִ� ����?" +session.getAttribute("pidx"));
		
		
		if(session.getAttribute("sidx") == null) {
			response.sendRedirect(request.getContextPath()+"/");
			
			//��Ʈ�ѷ��� ��û�� ������ �ʱ� ���ؼ� false ����			
			return false;			
		}
		
		if(session.getAttribute("pidx") == null) {
			response.sendRedirect(request.getContextPath()+"/");
			
			return false;
		}
		
		return true;
	}

}
