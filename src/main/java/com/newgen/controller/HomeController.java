package com.newgen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newgen.pojo.User;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(){
		return "home/main";
	}
	
	@RequestMapping("left")
	public String left_menu(){
		Session session = SecurityUtils.getSubject().getSession();
		User curUser = (User) session.getAttribute(User.class.getSimpleName());
		
		return "home/left";
	}
}
