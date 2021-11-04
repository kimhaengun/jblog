package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;

@Repository
public class BlogRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입시 생성되는 초기블로그
	public boolean intialinsert(BlogVo blogVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("blog.insert",blogVo);
		return result == 1;
	}	
	//기본설정 Update
	public boolean blogAdminBasicUpdate(BlogVo blogVo) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("blog.update",blogVo);
		return result == 1;
	}
	public BlogVo findByBlog(String blogId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("blog.findbyblog",blogId);
	}



}
