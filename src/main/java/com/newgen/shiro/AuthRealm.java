package com.newgen.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.newgen.pojo.User;
import com.newgen.service.UserService;


//安全管理需要继承的类
public class AuthRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;

	//权限管理   可以实现不同的用户展现不同的界面
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//权限列表   就是用户所拥有的权限信息
		/**权限实现的思路
		 * 1.拿到当前请求用户的名称
		 * 2.根据username 去数据库中查找   user_p----->role_user_p role_id
		 * -------->module_role_p module_id ------->module_p moduleName(权限名称)
		 */
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getSession().getAttribute("username");
		
		List<String> roleList = new ArrayList<String>();
		roleList.add("货运管理");
		roleList.add("基础信息");
		roleList.add("系统管理");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(roleList);
		return info;
	}

	//认证管理 登陆认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//强制转换
		/**
		 * 验证思路
		 * 通过用户传入的usename 去数据库中查找对象 
		 * 把对象传给shiro  shiro自动的根据对象中的密码做匹配
		 */
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		//获得用户传入的username
		String username = loginToken.getUsername();
		
		//通过username查询出对象
		User user = userService.selectUserByUsername(username);
		
		/**
		 * shiro安全认证的参数
		 * 1.查询回来的对象
		 * 2.正确的密码  user.getPassword()
		 * 3.当前info对象的名称
		 */
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		
		//当info对象创建完成后shiro 会在内部做比较  如果传入的密码和数据中的密码相同则放行 否则抛出异常
		return info;
	}

}
