<%@page import="cn.jiZhang.book.dao.BookDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'me.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<title></title>
		<style>
		.div{
		width="15%";
		height=""
		}
		</style>
	</head>
	<body background="img/1.jpg">
	<table border="1" align="center" width="80%" height="80%" border-color="#9900ff"  >
         <tr >
               <th valign="middle" width="100%" colspan="5"><font color="#9900ff" size="20px">查询账本信息</th>
         </tr>
        
        <%
			BookDao bookDao = new BookDao();
			pageContext.setAttribute("books", bookDao.findAll());
		%>
        
         <tr>
               <td width="15%">时间</td>
               <td width="15%">消费金额</td>
               <td colspan="2">消费原因</td>
               <td width="15%">删除记录</td>
         </tr>
         
         <c:forEach items="${books }" var="book">
         	<tr height="50px">
         	<td>${book.time }</td>
         	<td>${book.price }</td>
         	<td colspan="2">${book.reason }</td>
         	<td>
         		<a href="${pageContext.request.contextPath }/BookServlet?id=${book.id}" target="top"><input type="button" value="删除"></a>
         	</td>
         	
         </tr>
         </c:forEach>
         
         
</table>
</body>
</html>
