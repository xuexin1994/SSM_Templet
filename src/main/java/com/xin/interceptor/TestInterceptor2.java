package com.xin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义的拦截器
 * @author xuexin
 *
 */
public class TestInterceptor2 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String parameter = request.getParameter("Interceptor2");
		boolean b = "false".equals(parameter);
		if(b){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<h1>自定义拦截器2不放行</h1>");
		}
		System.out.println("自定义拦截器2的preHandle方法:"+!b);
		return !b;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("自定义拦截器2的postHandle方法");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("自定义拦截器2的afterCompletion方法");
	}

}
