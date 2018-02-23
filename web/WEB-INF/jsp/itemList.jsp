<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>
	名称:<input type="text" name="item.name"/><br/>
	描述:<input type="text" name="item.detail"/><br/>
	<input type="submit" value="查询"/>
</td>
</tr>
<tr>
</tr>
</table>
</form>
<%-- <form action="${pageContext.request.contextPath }/item/showSelectIds.action" method="post"> --%>
<%-- <form action="${pageContext.request.contextPath }/item/showUpdateList.action" method="post"> --%>
<form id="itemfrom" action="" method="post">
商品列表：
<table width="100%" border=1>
<tr>
	<td>
		<input type="button" value="显示选择" onclick="showSelect()"/>
		<input type="button" value="显示修改" onclick="showUpdate()"/>
	</td>
	<script type="text/javascript">
		function showSelect(){
			document.getElementById("itemfrom").action="${pageContext.request.contextPath }/item/showSelectIds.action"
			document.getElementById("itemfrom").submit();
		}
		function showUpdate(){
			document.getElementById("itemfrom").action="${pageContext.request.contextPath }/item/showUpdateList.action"
			document.getElementById("itemfrom").submit();
		}
	</script>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item" varStatus="status">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id }"></td>
	<td>
		<input type="hidden" value="${item.id }" name="itemList[${status.index}].id">
		<input type="text" value="${item.name }" name="itemList[${status.index}].name">
	</td>
	<td>
		<input type="text" value="${item.price }" name="itemList[${status.index}].price">
	</td>
	<td>
		<input type="text" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy-MM-dd HH:mm:ss'/>" name="itemList[${status.index}].createtime">
		</td>
	<td>
		<input type="text" value="${item.detail }" name="itemList[${status.index}].detail">
	</td>
	
	<td>
		<a href="${pageContext.request.contextPath }/item/itemEdit1.action?id=${item.id}">修改</a>
		<a href="${pageContext.request.contextPath }/restful/editItem/${item.id}/10/100/1000">修改(RESTful风格)</a>
	</td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>