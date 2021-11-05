package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//카테고리 list
	public List<CategoryVo> selectCategory(String blogId) {
		// TODO Auto-generated method stub
		List<CategoryVo> categoryList = sqlSession.selectList("category.selectcategorylist",blogId);
		System.out.println(categoryList);
		return categoryList;
	}
	
	//글작성
	public boolean postWrite(PostVo postVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("post.postwrite",postVo);
		return result == 1;
	}

}
