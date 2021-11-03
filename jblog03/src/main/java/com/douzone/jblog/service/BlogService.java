package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	//회원가입 시 생성되는 초기 블로그
	public void insert(String userId) {
		// TODO Auto-generated method stub
		BlogVo blogVo = new BlogVo();
		blogVo.setId(userId);
		blogVo.setTitle("제목");
		blogVo.setLogo("사진 없음");
		blogRepository.intialinsert(blogVo);
	}	
	//기본설정 Update
	public boolean blogAdminBasicUpdate(BlogVo blogVo) {
		// TODO Auto-generated method stub
		return blogRepository.blogAdminBasicUpdate(blogVo);
	}



}
