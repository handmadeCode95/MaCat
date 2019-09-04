package com.macat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	// 아직 컨텍스트를 등록하지 않았음
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object object = session.getAttribute("loginData");
		
		// 세션의 loginData가 null이면 로그인 페이지로 이동
		if (object == null) {
			response.sendRedirect("login");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 로그인처리를 이쪽에 재구현
		super.postHandle(request, response, handler, modelAndView);
	}
}
