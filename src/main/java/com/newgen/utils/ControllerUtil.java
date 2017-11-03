package com.newgen.utils;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;

public class ControllerUtil {
	public static JSONObject success(){
		return success(null);
	}
	public static JSONObject success(String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ret", 0);
		if(!StringUtils.isNullOrEmpty(msg)){
			jsonObject.put("msg", msg);
		}
		return jsonObject;
	}
	
	public static JSONObject faild(){
		return faild(null);
	}
	public static JSONObject faild(String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ret", 1);
		if(!StringUtils.isNullOrEmpty(msg)){
			jsonObject.put("msg", msg);
		}
		return jsonObject;
	}
}
