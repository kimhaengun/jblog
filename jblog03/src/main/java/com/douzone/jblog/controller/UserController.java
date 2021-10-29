package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인 페이지
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//회원가입 페이지
	@RequestMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(UserVo uservo) {
		System.out.println( "========="+uservo);
			userService.join(uservo);
		return "user/joinsuccess";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout() {
		return "";
	}
}
