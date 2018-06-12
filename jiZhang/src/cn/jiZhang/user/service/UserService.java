package cn.jiZhang.user.service;

import cn.jiZhang.user.dao.UserDao;
import cn.jiZhang.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	/*
	 * 注册方法
	 */
	public void regist(User form) throws UserException {
		/*
		 * 1：效验用户名， >如果用户名已经被注册，那么抛出异常（异常信息为：用户名已经被注册） 2：完成插入
		 */
		User user = userDao.findByUsername(form.getUsername());
		if (user != null)
			throw new UserException("用户名已被注册！");

		userDao.addUser(form);
	}

	/*
	 * 登录方法
	 */
	public User login(User form) throws UserException {
		// 使用form的username进行校验
		User user = userDao.findByUsername(form.getUsername());
		// 判断user是否为null，如果是null，说明用户名称错误
		if (user == null)
			throw new UserException("用户名有误！");

		// 判断form和user密码是否一致。如果不同说明密码有误
		if (!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码有误！");
		}

		// 到了这里，说明程序没有问题，就登录成功了
		return user;
	}
}
