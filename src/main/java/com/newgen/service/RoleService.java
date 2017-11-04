package com.newgen.service;

import java.util.List;

import com.newgen.pojo.Role;

public interface RoleService {
	List<Role> selectByUserId(Integer id);
}
