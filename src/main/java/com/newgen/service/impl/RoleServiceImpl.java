package com.newgen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newgen.mapper.RoleMapper;
import com.newgen.pojo.Role;
import com.newgen.pojo.User;
import com.newgen.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectByUserId(Integer id) {
		return roleMapper.selectByUserId(id);
	}

}
