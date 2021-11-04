package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;
import com.douzone.jblog.vo.dto.CategoryRespDto;


@Controller
@RequestMapping("/{cblogId}")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//카테고리 form
	@RequestMapping("/admin/category")
	public String category(@AuthUser UserVo userVo,
			@PathVariable("cblogId") String blogId,Model model) {
		System.out.println("카테고리에서 받은 Id값 : "+blogId);
		List<CategoryRespDto> list = categoryService.findByCategory(blogId);
		model.addAttribute("list",list);
		return "blog/blog-admin-category";
	}
	
	//카테고리 추가
	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public String categoryAdd(
			 CategoryVo categoryVo) {
		System.out.println("카테고리 추가내용 : "+categoryVo);
		categoryService.categoryAdd(categoryVo);
		return "redirect:/"+categoryVo.getBlogId()+"/admin/category";
	}
}
