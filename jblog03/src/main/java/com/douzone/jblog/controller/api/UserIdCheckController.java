package com.douzone.jblog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@RestController("userApiController")
@RequestMapping("/user/api")
public class UserIdCheckController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkid")
	public JsonResult IdCheck(@RequestParam(value = "id")String id) {
		System.out.println("ID값 들어옴? : "+ id);
		UserVo userVo = userService.IdCheck(id);
		
		return JsonResult.success(userVo!=null);
	}
}
