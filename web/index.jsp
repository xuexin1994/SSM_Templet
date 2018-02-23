<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/hello.action">Hello SpringMVC</a><br/>
	<a href="${pageContext.request.contextPath }/notAnnotation.action">This Is NotAnnotationController</a><br/>
	<a href="${pageContext.request.contextPath }/item/allList.action">显示所有item</a><br/>
	<a href="${pageContext.request.contextPath }/page/test_RequestMapping.action">@RequestMapping的测试</a><br/>
	<a href="${pageContext.request.contextPath }/page/test_ReturnType.action">处理器的返回值类型测试</a><br/>
	<a href="#" onclick="sendJson()">通过POST传递JSON数据</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		测试发送的id值：<input id="sendJson_id" type="text"/>&nbsp;&nbsp;&nbsp;
		测试发送的name值：<input id="sendJson_name" type="text"/><br/>
	<script type="text/javascript">
		function sendJson(){
			var sendJson_id = $("#sendJson_id").val();
			var sendJson_name = $("#sendJson_name").val();
			$.ajax({
				url:"${pageContext.request.contextPath }/json/testSendJson.action",
				type:"post",
				contentType:"application/json;charset=utf-8",
				data:'{"id":"'+sendJson_id+'","name":"'+sendJson_name+'"}',
				success:function(data){
					alert("id="+data.id+"*****name="+data.name)
				}
			})
		}
	</script>

	<a href="${pageContext.request.contextPath }/page/test_Exception_IntoInterceptor.action">测试全局异常&拦截器</a><br/>
</body>
</html>