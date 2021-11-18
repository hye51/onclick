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

		
			if(sidx != null) {
				HttpSession session = request.getSession();
				session.setAttribute("sidx", sidx);
//				//컨트롤러에서 Redirect를 해서 충돌 발생 Redirect 말고 jsp 파일로 보내면, 대시보드에서 강의 리스트를 받아올 수가 없음.
//				response.sendRedirect(request.getContextPath()+"/student/stuDashBoard.do");
			} 
			
			if(pidx != null) { 
				HttpSession session = request.getSession();
				session.setAttribute("pidx", pidx);
//				response.sendRedirect(request.getContextPath()+"/professor/proDashBoard.do");
			}
		
	}	


}
