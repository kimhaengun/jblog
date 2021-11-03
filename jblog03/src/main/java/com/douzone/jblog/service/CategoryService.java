package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	//초기 카테고리 (미분류) 생성
	public boolean insert(String userId) {
		// TODO Auto-generated method stub
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName("미분류");
		categoryVo.setDesc("카테고리 설명 미설정");
		categoryVo.setBlogId(userId);
		return categoryRepository.intialinsert(categoryVo);
	}

}
