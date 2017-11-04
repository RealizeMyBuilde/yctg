package com.newgen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.mapper.UserMapper;
import com.newgen.pojo.User;
import com.newgen.service.UserService;

@Service("userService")
public class UserServerImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User selectUserByUsername(String username) {
		User user = new User();
		user.setUsername(username);
		User curUser = userMapper.selectOne(user);
		return curUser;
	}

}
