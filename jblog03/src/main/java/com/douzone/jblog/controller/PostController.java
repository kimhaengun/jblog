package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/{adminId}")
public class PostController {

	@Autowired
	private PostService postService;
	
	//글작성 form
	@RequestMapping("/admin/write")
	public String write(@AuthUser UserVo userVo,
			@PathVariable("adminId")String blogId,Model model) {
		List<CategoryVo> categoryList = postService.selectCategory(blogId);
		model.addAttribute("categoryList",categoryList);
		return "blog/blog-admin-write";
	}
	//글작성
	@RequestMapping(value = "/admin/write", method = RequestMethod.POST)
	public String write(@AuthUser UserVo userVo,
			@PathVariable("adminId")String blogId, PostVo postVo) {
			System.out.println("글쓰기에서 받아온 postVo : "+postVo); //성공
			postService.postWrite(postVo);
		return "redirect:/"+blogId;
	}
}
