package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String main(@PathVariable("blogId") String blogId,Model model) {
		System.out.println("받아온 blogId : "+ blogId); //성공
		
		
		return "blog/blog-main";
	}
	//블로그 관리 form
	@RequestMapping("/admin")
	public String blogAdminBasic(@AuthUser UserVo userVo,
			@PathVariable("blogId") String blogId,Model model) {
		BlogVo blogVo = blogService.findByBlog(blogId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}
	//기본설정 Update
	@RequestMapping(value = "/admin/update",method = RequestMethod.POST)
	public String blogAdminBasicUpdate(
			BlogVo blogVo,@RequestParam("logo-file") MultipartFile file, Model model) {
		System.out.println("기본설정 변경 주소 요청됨"); //성공
		System.out.println("기본설정 변경 버튼 : "+blogVo);//성공
		
		blogService.blogAdminBasicUpdate(blogVo,file);
		return "redirect:/"+blogVo.getId()+"/admin";
	}

}
