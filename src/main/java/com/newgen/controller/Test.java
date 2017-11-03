package com.newgen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Test")

public class Test {
	@RequestMapping("/test1")
	@ResponseBody
	public String test1(){
		return "success";
	}
}
