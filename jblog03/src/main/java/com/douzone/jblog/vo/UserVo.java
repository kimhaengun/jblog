package com.douzone.jblog.vo;

public class UserVo {
	private String name;
	private String id;
	private String password;
	private String regDate;
	public String getname() {
		return name;
	}
	public void setname(String username) {
		this.name = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserRepository [username=" + name + ", id=" + id + ", password=" + password + ", regDate=" + regDate
				+ "]";
	}
}
