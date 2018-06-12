package cn.jiZhang.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.jiZhang.book.domain.Book;
import cn.jiZhang.book.service.BookService;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	/*
	 * 添加
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 处理编码问题
		 */
		response.setContentType("text/html;charset=UTF-8");// 处理响应编码
		request.setCharacterEncoding("UTF-8");
		BookService bookService = new BookService();
		/*
		 * 获取参数
		 */
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		// 执行Service add方法
		bookService.add(book);
		// 添加成功信息
		request.setAttribute("success", "恭喜，添加成功！");
		// 转发到add.jsp
		request.getRequestDispatcher("/add.jsp").forward(request, response);

	}

}
