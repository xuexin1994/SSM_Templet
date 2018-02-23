<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RequestMapping注解测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestMethod.action">@RequestMapping中的method属性</a><br/>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestParamsInclude.action">@RequestMapping中的params属性(必须有id参数)</a><br/>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestParamsExclued.action?id=1">@RequestMapping中的params属性(必须没有id参数)</a><br/>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestParamsNoEqual.action?id=1">@RequestMapping中的params属性(必须有id参数且不为1)</a><br/>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestSamePath.action">访问testRequestSamePath路径(不带参数)</a><br/>
	<a href="${pageContext.request.contextPath }/requestMapping/testRequestSamePath.action?id=1">访问testRequestSamePath路径(带参数)</a><br/>
</body>
</html>