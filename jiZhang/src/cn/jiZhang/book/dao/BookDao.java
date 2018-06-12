package cn.jiZhang.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.jiZhang.book.domain.Book;

//持久层
public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加账单
	 */
	public void add(Book b) {
		try {
			String sql = "INSERT INTO books (price,time,reason)VALUES(?,?,?)";
			Object[] params = { b.getPrice(), b.getTime(), b.getReason() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询所有
	 */
	public List<Book> findAll() {
		try {
			String sql = "select * from books";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除客户
	 * 
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		String sql = "delete from books where id = ?";
		qr.update(sql, id);
	}
}
