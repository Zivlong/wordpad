<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>注册界面</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />

<script type="text/javascript">
	<script type="text/javascript" src="js/jquery.min.js">
</script>
<script type="text/javascript">
	function _change() {
		/*
		1. 获取img元素
		 */
		var imgEle = document.getElementById("imgEle");
		// 设置它的src为servlet
		imgEle.src = "<c:url value='/VerifyCodeServlet'/>?"
				+ new Date().getTime();
	}
</script>
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">

			<div class="logo"></div>

			<div class="login_box">

				<div class="login_form">
					<div class="login_title">注册</div>
					<form action="<c:url value='/RegistServlet'/>" method="post">
						<div>
						<font align="center" style="color: red; font-size: 11pt; font-weight: 900;">${msg}</font>
						</div>
						<div class="form_text_ipt">
							<input name="username" type="text" placeholder="用户名"
								value="${form.username }" /> <span
								style="color: red; font-size: 10pt; font-weight: 900;">${errors.username
								}</span>
						</div>
						<div class="ececk_warning">
							<span>用户名不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="password" type="password" placeholder="密码"
								value="${form.password }"> <span
								style="color: red; font-size: 10pt; font-weight: 900;">${errors.password
								}</span>
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="repassword" type="password" placeholder="重复密码"
								value="${form.repassword }"> <span
								style="color: red; font-size: 10pt; font-weight: 900;">${errors.repassword
								}</span><br />
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="verifyCode" type="text" placeholder="验证码"
								value="${form.verifyCode }"> <img
								src="<c:url value='/VerifyCodeServlet'/>" id="imgEle" /> <a
								href="javascript:_change()">换一张</a>
						</div>
						<div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
								style="color: red; font-size: 10pt; font-weight: 900;">${errors.verifyCode}</span>
						</div>
						<div class="form_btn">
							<button type="button" onclick="this.form.submit()">注册</button>
						</div>
						<div class="form_reg_btn">
							<span>已有帐号？</span><a href="index.jsp">马上登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<div style="text-align:center;"></div>
</body>
</html>
