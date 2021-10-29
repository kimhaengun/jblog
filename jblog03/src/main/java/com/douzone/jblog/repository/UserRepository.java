package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean join(UserVo uservo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("user.insert",uservo);
		return result == 1;
	}

	public UserVo login(UserVo userVo) {
		// TODO Auto-generated method stub
		UserVo vo = sqlSession.selectOne("user.select",userVo);
		return vo;
	}
	
	
}
