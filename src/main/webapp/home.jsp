<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>系统主页</title>
</head>
<body>
	<h3>系统主页（受保护页面）</h3>
	<p>当前登录用户：<%= session.getAttribute("loginUser") %> </p>
	<p>当前用户级别: <%= session.getAttribute("class") %>
	<p>这是只有登录后才能访问的业务页面，用于演示过滤器的访问控制。</p>
	<p>
		<a href="<%=request.getContextPath()%>/logoutservlet">退出登录</a>
	</p>
</body>
</html>
