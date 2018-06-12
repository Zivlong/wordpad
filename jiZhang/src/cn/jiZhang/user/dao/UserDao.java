package cn.jiZhang.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jiZhang.user.domain.User;

//持久层
public class UserDao {
	// 添加用户
	public void addUser(User form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "insert into users values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, form.getUsername());
			pstmt.setString(2, form.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 根据用户名查找用户
	public User findByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select * from users where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				// 转换成User对象，并返回
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
