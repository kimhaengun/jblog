package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/{blogId}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	//메인 블로그 Form
	@RequestMapping({""})
	public String main(@PathVariable("blogId") String blogId) {
		System.out.println("받아온 blogId : "+ blogId);
		return "blog/blog-main";
	}
	//블로그 관리 form
	@RequestMapping("/admin")
	public String blogAdminBasic(@AuthUser UserVo userVo) {

		return "blog/blog-admin-basic";
	}
	//기본설정 Update
	@RequestMapping("/admin/update")
	public boolean blogAdminBasicUpdate(BlogVo blogVo) {
		return blogService.blogAdminBasicUpdate(blogVo);
	}
	
	//카테고리 form
	@RequestMapping("/admin/category")
	public String category(@AuthUser UserVo userVo) {
		return "blog/blog-admin-category";
	}
	//글작성 form
	@RequestMapping("/admin/write")
	public String write(@AuthUser UserVo userVo) {
		return "blog/blog-admin-write";
	}

}
