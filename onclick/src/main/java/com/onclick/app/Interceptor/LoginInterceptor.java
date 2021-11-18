package com.onclick.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//�α����� �ϰ� �� �� ���ǰ��� ��� ����  ������ �ϴ� Ŭ����
	
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			ModelAndView modelAndView
			) throws Exception {

			Object sidx = modelAndView.getModel().get("sidx");
//			System.out.println("�𵨿� ��� ����?"+sidx);
			
			Object pidx = modelAndView.getModel().get("pidx");
//			System.out.println("�𵨿� ��� ����?"+pidx);

		
			if(sidx != null) {
				HttpSession session = request.getSession();
				session.setAttribute("sidx", sidx);
//				//��Ʈ�ѷ����� Redirect�� �ؼ� �浹 �߻� Redirect ���� jsp ���Ϸ� ������, ��ú��忡�� ���� ����Ʈ�� �޾ƿ� ���� ����.
//				response.sendRedirect(request.getContextPath()+"/student/stuDashBoard.do");
			} 
			
			if(pidx != null) { 
				HttpSession session = request.getSession();
				session.setAttribute("pidx", pidx);
//				response.sendRedirect(request.getContextPath()+"/professor/proDashBoard.do");
			}
		
	}	


}
