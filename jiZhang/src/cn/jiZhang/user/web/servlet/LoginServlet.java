package cn.jiZhang.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.jiZhang.user.domain.User;
import cn.jiZhang.user.service.UserException;
import cn.jiZhang.user.service.UserService;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 依赖service
		UserService userService = new UserService();
		
		// 封装表单数据
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			/*
			 * 执行到这里，说明登录成功了
			 */
			// 保存当前用户到session中
			request.getSession().setAttribute("session_user", user);
			// 转发到到welcome.jsp
			
			request.getRequestDispatcher("/welcome.jsp").forward(request,
					response);
		} catch (UserException e) {
			/*
			 * 执行到这里，说明登录失败 1. 保存异常信息、form，到reuqest域 2. 转发到login.jsp
			 */
			request.setAttribute("msg", "用户名，或者密码有误");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
	}

}
