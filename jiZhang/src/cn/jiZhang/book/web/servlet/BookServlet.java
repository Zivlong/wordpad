package cn.jiZhang.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jiZhang.book.service.BookService;

public class BookServlet extends HttpServlet {

	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			bookService
					.deleteById(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
