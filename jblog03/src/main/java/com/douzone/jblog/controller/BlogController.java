package com.douzone.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.dto.BlogmainReqDto;
import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/{blogId:(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;

	// 메인 블로그 Form
	@RequestMapping({"","/{categoryNo}","/{categoryNo}/{postNo}"})
	public String main(@PathVariable("blogId") String blogId, 
			@PathVariable("categoryNo") Optional<Long> categoryNo,
			@PathVariable("postNo") Optional<Long> no, 
			Model model) {
		System.out.println("받아온 blogId : " + blogId); // 성공
//		System.out.println("받아온 카테고리No : "+categoryNo); //성공 optionp[]
		
		// *첫 메인화면*
		// 블로그 정보
		BlogVo blogvo = blogService.blogmain(blogId);
		model.addAttribute("blogVo", blogvo);
		// 카테고리
		List<CategoryVo> categorylist = categoryService.blogmain(blogId);
		model.addAttribute("categorylist", categorylist);
		
		if(categoryNo.isPresent()) { //categoryno null이아니면
			BlogmainReqDto dto = new BlogmainReqDto();
			dto.setBlogId(blogId);
			dto.setCategoryNo(categoryNo.get());
			List<PostVo> postlist = postService.blogCategoryPostList(dto);
			System.out.println("카테고리.....post:"+postlist);
			model.addAttribute("postlist",postlist);
			
			if(no.isPresent()) { // 둘다 null 이아니면 / categoryno,postno
				dto.setPostNo(no.get());
				//포스트 상세보기
				PostVo maxpost = postService.findBlogPost(dto);
				model.addAttribute("maxpost",maxpost);
				return "blog/blog-main";
			}else{ //현재 카테고리 no 받아와서 제일 no값 높은 포스트 가져오기
				PostVo maxpost = postService.blogmainpost(dto);
				model.addAttribute("maxpost",maxpost);
				return "blog/blog-main";	
			}
		}else {
			// 카테고리 중 가장 min(no)값 글 리스트 정보 / 초기값임.
			List<PostVo> postlist = postService.blodmain(blogId);
			// 카테고리 중 가장 min(no)값 글 리스트 중 가장 최근 글(max) 정보 /초기값임.
			model.addAttribute("postlist", postlist);
			PostVo maxpost = postService.blogmainpost(blogId);
			model.addAttribute("maxpost", maxpost);
			return "blog/blog-main";				
		}

	}

	// 블로그 관리 form
	@RequestMapping("/admin")
	public String blogAdminBasic(@AuthUser UserVo userVo, @PathVariable("blogId") String blogId, Model model) {
		BlogVo blogVo = blogService.findByBlog(blogId);
		model.addAttribute("blogmainVo", blogVo);
		return "blog/blog-admin-basic";
	}

	// 기본설정 Update
	@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
	public String blogAdminBasicUpdate(BlogVo blogVo, @RequestParam("logo-file") MultipartFile file, Model model) {
		System.out.println("기본설정 변경 주소 요청됨"); // 성공
		System.out.println("기본설정 변경 버튼 : " + blogVo);// 성공
		System.out.println(file);
		blogService.blogAdminBasicUpdate(blogVo, file);
		return "redirect:/" + blogVo.getId() + "/admin";
	}

}
