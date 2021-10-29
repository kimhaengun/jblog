package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void join(UserVo uservo) {
		userRepository.join(uservo);
	}
	
	public UserVo login(UserVo userVo) {
		// TODO Auto-generated method stub
		return userRepository.login(userVo);
	}

}
