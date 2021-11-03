package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;

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

}
