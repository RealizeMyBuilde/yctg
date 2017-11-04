package com.newgen.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name= "t_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;
	@Column
	private String password;
	@Column(name= "createTime")
	private Date createTime;
	@Column
	private Integer state;
	@Column(name = "deleteFlag")
	private Integer deleteFlag;
	
	@Transient
	private List<Role> roles;
	
	@Transient
	private Set<Permission> permissions;
	
	@Transient
	private Set<Menu> menus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
		this.permissions = new HashSet<>();
		this.menus = new HashSet<>();
		for (Role role : roles) {
			for (Permission permission : role.getPermissions()) {
				permissions.add(permission);
				for (Menu menu : permission.getMenus()) {
					menus.add(menu);
				}
			}
		}
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	public boolean isLock(){
		return 0 == this.state;
	}
	public boolean canLogin(){
		for (Role role : roles) {
			if(null != role && null != role.getCanlogin() && role.getCanlogin() == 0){
				return true;
			}
		}
		return false;
	}
}
