<%@page import="cn.jiZhang.book.dao.BookDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body background="img/1.jpg">
	<font color="red">${success }</font>
	<table border="1" align="center" width="80%" height="80%"
		border-color="#9900ff">
		<tr>
			<th width="100%" height="20px" colspan="4">
				<fontcolor="#9900ff" size="20px">添加账单信息
			</th>
		</tr>
		<tr>
			<td width="15%" height="30">时间</td>
			<td width="15%">消费金额</td>
			<td colspan="2">消费原因</td>
		</tr>
		<form action="<c:url value='/AddServlet'/>" method="post">
		<tr>
			<td width="15%" height="30"><input type="text" name="time"/></td>
			<td width="15%"><input type="text" name="price"/></td>
			<td colspan="2" ><input type="text" size="100px" name="reason"/></td>
		</tr>
		<tr align="center">
			<td colspan = "4" height="10px"><input type="submit"></td>
		</tr>
		</form>	
	</table>
</body>
</html>
