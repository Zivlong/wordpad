package cn.jiZhang.user.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 创建验证码类
		VerifyCode verifyCode = new VerifyCode();
		// 得到验证码图片
		BufferedImage image = verifyCode.getImage();
		// 保存验证码文字到session域中
		request.getSession().setAttribute("vCode", verifyCode.getText());
		// 把图片响应到注册页面中
		verifyCode.output(image, response.getOutputStream());
	}
}
