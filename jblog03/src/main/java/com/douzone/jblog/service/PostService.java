package com.douzone.jblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.dto.BlogmainReqDto;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//카테고리 list
	public List<CategoryVo> selectCategory(String blogId) {
		// TODO Auto-generated method stub
		return postRepository.selectCategory(blogId);
	}
	//글작성
	public boolean postWrite(PostVo postVo) {
		return postRepository.postWrite(postVo);
	}
	
	//블로그 메인 정보
	public List<PostVo> blodmain(String blogId) {
		// TODO Auto-generated method stub
		return postRepository.blogmain(blogId);
	}
	//카테고리 중 가장 min(no)값 글 리스트 중 가장 최근 글(max) 정보	
	public PostVo blogmainpost(String blogId) {
		// TODO Auto-generated method stub
		return postRepository.blogmainpost(blogId);
	}
	public List<PostVo> blogCategoryPostList(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		return postRepository.blogCategoryPostList(dto);
	}
	
	//현재 카테고리 no 받아와서 제일 no값 높은 포스트 가져오기
	public PostVo blogmainpost(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		return postRepository.blogCategoryMaxpost(dto);
	}
	//포스트 상세보기
	public PostVo findBlogPost(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		return postRepository.findBlogPost(dto);
	}

}
