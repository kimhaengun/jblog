package com.douzone.jblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.dto.CategoryRespDto;

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
	
	//카테고리 추가
	public boolean categoryAdd(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		
		return categoryRepository.categoryAdd(categoryVo);
	}
	
	//카테고리 조회
	public List<CategoryRespDto> findByCategory(String blogId) {
		// TODO Auto-generated method stub
		List<CategoryRespDto> list = categoryRepository.findByCategory(blogId);
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCount() == null) {
				list.get(i).setCount(0L);
			}
		}
		return list;
	}
	
	//블로그 메인 정보
	public List<CategoryVo> blogmain(String blogId) {
		// TODO Auto-generated method stub
		List<CategoryVo> list= categoryRepository.blogmain(blogId);
		return list;
	}

	//삭제
	public boolean categorydelete(String no) {
		// TODO Auto-generated method stub
		
		return categoryRepository.categorydelete(no);
	}

}
