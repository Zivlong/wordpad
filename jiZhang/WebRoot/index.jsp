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

<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>登录界面</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
</head>

<body>
	<div class="wrap login_wrap">
		<div class="content">
			<div class="logo"></div>
			<div class="login_box">

				<div class="login_form">
					<div class="login_title">登录</div>
					<div>
						<p style="color: red; font-size: 11pt; font-weight: 900;">${msg }</p>
					</div>
					<form action="<c:url value='/LoginServlet'/>" method="post">

						<div class="form_text_ipt">
							<input name="username" type="text" placeholder="用户名"
								value="${form.username}" />
						</div>
						<div class="ececk_warning">
							<span>用户名不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="password" type="password" placeholder="密码"
								value="${form.password }" />
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_check_ipt">
							<div class="left check_left">
								<label><input name="" type="checkbox"> 下次自动登录</label>
							</div>
							<div class="right check_right">
								<a href="#">忘记密码</a>
							</div>
						</div>
						<div class="form_btn">
							<button type="button"
								onclick="this.form.submit()">登录</button>
						</div>
						<div class="form_reg_btn">
							<span>还没有帐号？</span><a href="regist.jsp">马上注册</a>
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

