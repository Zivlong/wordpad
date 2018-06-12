package cn.jiZhang.user.service;

//自定义异常类
public class UserException extends Exception {
	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}
}
