package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserVo {
	
	@NotEmpty
	@Length(min=2,max=8)
	private String name;
	@NotEmpty
	private String id;
	@NotEmpty
	@Length(min = 4,max=16)
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
