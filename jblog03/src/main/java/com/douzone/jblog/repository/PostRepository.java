package com.douzone.jblog.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.dto.BlogmainReqDto;
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
	
	//블로그 메인 정보
	public List<PostVo> blogmain(String blogId) {
		// TODO Auto-generated method stub
		List<PostVo> postlist = sqlSession.selectList("post.blogmain",blogId);
		return postlist;
	}

	public PostVo blogmainpost(String blogId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("post.blogmainpost",blogId);
	}

	public List<PostVo> blogCategoryPostList(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		List<PostVo> postlist = sqlSession.selectList("post.blogcategorypostlist",dto);
		
		return postlist;
	}
	//현재 카테고리 no 받아와서 제일 no값 높은 포스트 가져오기
	public PostVo blogCategoryMaxpost(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("post.blogcatrgorymaxpost",dto);
	}
	//포스트 상세보기
	public PostVo findBlogPost(BlogmainReqDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("post.findblogpost",dto);
	}

}
