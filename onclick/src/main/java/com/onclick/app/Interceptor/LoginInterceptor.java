package com.onclick.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//로그인을 하고 난 후 세션값을 담아 놓는  역할을 하는 클래스
	
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }
	
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		
		// 메소드 동작 전에 세션값이 있으면 제거
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sidx") != null) {
			session.removeAttribute("sidx");
		}
		
		if(session.getAttribute("pidx") != null) {
			session.removeAttribute("pidx");
		}
		
		return true;
	}
	
	


}
