package cn.jiZhang.book.service;

import java.sql.SQLException;

import cn.jiZhang.book.dao.BookDao;
import cn.jiZhang.book.domain.Book;

public class BookService {

	private BookDao bookDao = new BookDao();
	
	public void deleteById(int id) throws SQLException {
		bookDao.delete(id);
	}

	public void add(Book book) {
		// 添加账单方法
		bookDao.add(book);
	}
	
}
