package org.app.entity;

public class User {

	private Integer user_id;// 主键

	private String username;// 用户名
	private String name;// 昵称

	private String password;// 密码

	private String email;// 邮箱
	private String introduction;// 个人简介
	private String aboutme;// 关于我的
	private String hdimage;// 头像

	
	public User(Integer user_id, String username, String name, String password, String email, String introduction) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.introduction = introduction;
	}

	public User(String username, String name, String password, String email, String introduction) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "[user_id=" + user_id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", introduction=" + introduction + ", aboutme=" + aboutme + ", hdimage="
				+ hdimage + "]";
	}

	public User(Integer user_id, String username, String name, String password, String email, String introduction,
			String aboutme, String hdimage) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.introduction = introduction;
		this.aboutme = aboutme;
		this.hdimage = hdimage;
	}

	public User() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getHdimage() {
		return hdimage;
	}

	public void setHdimage(String hdimage) {
		this.hdimage = hdimage;
	}

}
