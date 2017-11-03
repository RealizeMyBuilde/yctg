package com.newgen.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.newgen.pojo.User;
import com.newgen.service.UserService;
import com.newgen.utils.ControllerUtil;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login_ui(){
		return "user/login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject login(User user){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			subject.login(token);
			User curUser = (User) subject.getPrincipal();
			
			//获取角色 判断是否为后台管理人员
			subject.getSession().setAttribute(User.class.getSimpleName(), user);
			return ControllerUtil.success();
		}catch(Exception e){
			return ControllerUtil.faild("用户名或密码错误");
		}
	}
}
