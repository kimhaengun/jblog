package com.douzone.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping({"","/"})
	public String index() {
		System.out.println("index 호출 됨");
		return "main/index";
	}
}
