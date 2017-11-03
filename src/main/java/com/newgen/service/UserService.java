package com.newgen.service;

import org.springframework.stereotype.Service;

import com.newgen.pojo.User;

public interface UserService {
	User selectUserByUsername(String username);
}
