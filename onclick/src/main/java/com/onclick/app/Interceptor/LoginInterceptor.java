package com.onclick.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//�α����� �ϰ� �� �� ���ǰ��� ��� ����  ������ �ϴ� Ŭ����
	
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
		
		// �޼ҵ� ���� ���� ���ǰ��� ������ ����
		
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
