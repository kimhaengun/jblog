package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.dto.CategoryRespDto;

@Repository
public class CategoryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//초기 카테고리 (미분류) 생성
	public boolean  intialinsert(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("category.intialinsert",categoryVo);
		return result == 1;
	}

	//카테고리 생성
	public boolean categoryAdd(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("category.categoryadd",categoryVo);
		return result == 1;
	}

	//카테고리 조회
	public List<CategoryRespDto> findByCategory(String blogId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("category.findbycategory",blogId);
	}

}
