package com.newgen.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


//专门用来做加密
public class AuthCredential extends SimpleCredentialsMatcher{
	
	/**
	 * shiro中的加密规则 
	 * 首先把用户传入的password经过加密之后与原来用户的密码比较 如果比较成功则能正确的跳转
	 * 
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//得到当前用户传入的用户民和密码
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		//需要将密码字符数组转化为字符串
		String password = String.valueOf(loginToken.getPassword());
		//生成加密后的密文
		String md5Password = password;
		
		loginToken.setPassword(md5Password.toCharArray());
		
		return super.doCredentialsMatch(loginToken, info);
	}
}	
