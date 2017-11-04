package com.newgen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.newgen.pojo.Role;

public interface RoleMapper extends Mapper<Role>{
	List<Role> selectByUserId(@Param("userid")Integer id);
}
