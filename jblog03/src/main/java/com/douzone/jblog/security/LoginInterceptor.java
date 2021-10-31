package com.douzone.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserVo authUser = userService.login(id,password);
		if(authUser == null) {
			request.setAttribute(("result"), "fail");
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
				   .forward(request, response);
			return false;
		}
		
		//session 처리
		System.out.println("인터셉터에서 받은 Session 정보 :"+authUser);
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		response.sendRedirect(request.getContextPath());
		return false; //인증 (세션) 처리
	}

}
