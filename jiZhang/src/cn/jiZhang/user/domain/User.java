package cn.jiZhang.user.domain;

public class User {
	// 对应数据库
	private String username;
	private String password;

	/**
	 * 对应表单 登录界面：username和password 注册页面：username、repassword、和verifyCode
	 */
	private String repassword;// 确认密码
	private String verifyCode;// 验证码

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", repassword=" + repassword + ", verifyCode=" + verifyCode
				+ "]";
	}

}
