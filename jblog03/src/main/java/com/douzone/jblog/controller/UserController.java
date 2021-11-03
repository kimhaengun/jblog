package com.douzone.jblog.controller;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	
	//로그인 페이지
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	
	//회원가입 페이지
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo userVo,BindingResult result,Model model) {
		System.out.println( "========="+userVo);
		if(result.hasErrors()) {
			//에러 있을 경우 사용자에게 기존 값을 제공해야함
			model.addAllAttributes(result.getModel());
			
			return "user/join";
		}
			//회원가입
			userService.join(userVo);
			
			//초기 블로그 생성
			String userId = userVo.getId();
			System.out.println("블로그 userId 확인 : "+userId);
			blogService.insert(userId);
			
			//초기 카테고리(미분류) 생성
			categoryService.insert(userId);
			
		return "user/joinsuccess";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout() {
		return "";
	}
}
