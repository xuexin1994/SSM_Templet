<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理器的返回值类型测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/requestType/modelAndView.action">通过ModelAndView转跳(mv.setViewName("success"))</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/modelAndView_Forward.action">通过ModelAndView转跳(mv.setViewName("forward:/success.jsp"))</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/modelAndView_Redirect.action">通过ModelAndView转跳(mv.setViewName("redirect:/success.jsp"))</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/requestForward.action">测试原生的request的请求转发</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/responseRedirect.action">测试原生的response的重定向</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/returnString.action">测试返回string类型的请求转发(return "success")</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/returnStringForward.action">测试返回string类型的请求转发(return "forward:/success.jsp")</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/returnStringRedirect.action">测试重定向到其它路径(return "redirect:/success.jsp")</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/returnStringRedirectOther.action">测试重定向到其他域名(return "redirect:http://www.baidu.com")</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/testRedirectAttributes_AddAttribute.action">测试RedirectAttributes的addAttribute方法</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/testRedirectAttributes_AddFlashAttribute_GetAttributeInPage1.action">测试RedirectAttributes的addFlashAttribute方法在页面的取值1(return "redirect:/success.jsp")(通过el表达式无法取出值(个人猜测：直接定向到页面，没有通过SpringMVC的视图解析器,所以无法从FlashMap中取出值))</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/testRedirectAttributes_AddFlashAttribute_GetAttributeInPage2.action">测试RedirectAttributes的addFlashAttribute方法在页面的取值2(return "redirect:/page/success.action")(通过el表达式可以取出值(个人猜测：再次通过SpringMVC的视图解析器,所以可以FlashMap中取出值))</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/testRedirectAttributes_AddFlashAttribute_GetAttributeInController1.action">测试RedirectAttributes的addFlashAttribute方法在后台的取值1</a><br/>
	<a href="${pageContext.request.contextPath }/requestType/testRedirectAttributes_AddFlashAttribute_GetAttributeInController2.action">测试RedirectAttributes的addFlashAttribute方法在后台的取值2</a><br/>
</body>
</html>