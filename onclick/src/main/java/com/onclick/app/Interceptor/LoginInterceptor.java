package com.onclick.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//로그인을 하고 난 후 세션값을 담아 놓는  역할을 하는 클래스
	
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			ModelAndView modelAndView
			) throws Exception {

			Object sidx = modelAndView.getModel().get("sidx");
//			System.out.println("모델에 담긴 값은?"+sidx);
			
			Object pidx = modelAndView.getModel().get("pidx");
//			System.out.println("모델에 담긴 값은?"+pidx);

			HttpSession session = request.getSession();
			
			if(sidx != null) {			
				session.setAttribute("sidx", sidx);

//				response.sendRedirect(request.getContextPath()+"/student/stuDashBoard.do");
			} 
			
			if(pidx != null) { 
				session.setAttribute("pidx", pidx);
//				response.sendRedirect(request.getContextPath()+"/professor/proDashBoard.do");
			}
		
	}
	
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		
		// 메소드 동작 전에 세션값이 있으면 제거
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sidx") != null) {
			session.removeAttribute("sidx");
			session.invalidate();
		}
		
		if(session.getAttribute("pidx") != null) {
			session.removeAttribute("pidx");
			session.invalidate();
		}
		
		return true;
	}
	
	


}
