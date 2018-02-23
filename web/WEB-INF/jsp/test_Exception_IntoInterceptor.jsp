<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试全局异常&拦截器</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/exception_IntoInterceptor/customerException.action">测试预期异常</a><br/>
	<a href="${pageContext.request.contextPath }/exception_IntoInterceptor/runtimeException.action">测试未知异常</a><br/>
	<a href="${pageContext.request.contextPath }/hello.action?Interceptor1=false">只进入拦截器一(不放行)</a><br/>
	<a href="${pageContext.request.contextPath }/exception_IntoInterceptor/intoInterceptor2.action?Interceptor1=false">进入两个拦截器，拦截器一不放行</a><br/>
	<a href="${pageContext.request.contextPath }/exception_IntoInterceptor/intoInterceptor2.action?Interceptor2=false">进入两个拦截器，拦截器二不放行</a><br/>
	<a href="${pageContext.request.contextPath }/exception_IntoInterceptor/intoInterceptor2.action">进入两个拦截器，都放行</a><br/>
</body>
</html>