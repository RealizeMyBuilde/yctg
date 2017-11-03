<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中国质量新闻网远程投稿系统</title>

<link href="${ctx }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx }/plugs/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx }/plugs/jquery-form/jquery.form.js"></script>
<script type="text/javascript" src="${ctx }/js/user/login.js"></script>

</head>

<body
	style="background-color:#1c77ac; background-image:url(${ctx }/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录远程投稿管理平台</span>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>
		<form id="login_form" method="POST" action="${ctx }/login.shtml">
			<div class="loginbox">

				<ul>
					<li><input id="username" name="username" type="text" class="loginuser"
						placeholder='用户名' /></li>
					<li><input id="password" name="password" type="password" class="loginpwd"
						placeholder='密  码' /></li>
					<li><input type="submit" class="loginbtn" value="登录" /><label><input
							name="remember" type="checkbox" value="" checked="checked" />记住密码</label><label><a
							href="#">忘记密码？</a></label></li>
				</ul>
		</form>
	</div>
	<div class="loginbm">中国质量新闻网远程投稿管理平台</div>
</body>
</html>