package cn.jiZhang.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.jiZhang.user.domain.User;
import cn.jiZhang.user.service.UserException;
import cn.jiZhang.user.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理编码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 依赖service
		UserService userService = new UserService();
		// 封装表单数据
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		// 创建错误集对象
		Map<String, String> errors = new HashMap<String, String>();
		// 校验用户名
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		} else if (username.length() < 5) {
			errors.put("username", "用户名长度须大于五位");
		}

		// 效验密码
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() < 6 || password.length() > 15) {
			errors.put("password", "密码长度须6~15位！");
		}

		// 效验确认密码
		String repassword = form.getRepassword();
		if (repassword == null || repassword.trim().isEmpty()) {// 非空校验
			errors.put("repassword", "确认密码不能为空！");
		} else if (!password.equals(repassword)) {// 是否相同校验
			errors.put("repassword", "两次密码输入不一致！");
		}

		/*
		 * 验证码
		 */
		String verifyCode = form.getVerifyCode();
		String session_vcode = (String) request.getSession().getAttribute(
				"vCode");
		if (verifyCode == null || verifyCode.trim().isEmpty()) {// 非空校验
			errors.put("verifyCode", "验证码不能为空！");
		} else if (!verifyCode.equalsIgnoreCase(session_vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}

		// 判断错误集是否含有错误，以及对错误集的处理
		if (errors.size() > 0) {
			// 保存errors到request域
			request.setAttribute("errors", errors);
			// 保存表单数据，为了页面的回显
			request.setAttribute("form", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}

		/*
		 * 调用userService方法完成逻辑
		 */
		try {
			userService.regist(form);
			/*
			 * 执行到这里，说明注册成功！转发页面到登录
			 */
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} catch (UserException e) {
			/*
			 * 执行到这里，说明注册失败了！ 获取异常信息，保存到request域，保存form到request域，转发回regist.jsp
			 */
			// 保存异常信息到request域
			request.setAttribute("msg", e.getMessage());
			// 保存表单数据，为了页面的回显
			request.setAttribute("form", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}
	}
}
