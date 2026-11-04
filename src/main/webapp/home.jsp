Z<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 页面级二次校验：未登录直接回登录页（过滤器已拦截，这里做双保险）
	Object key = session.getAttribute("loginUser");
	if (!"admin".equals(key)) {
		response.sendRedirect(request.getContextPath() + "/login.html");
		return;
	}
	String username = (String) session.getAttribute("username");
	if (username == null) {
		username = "";
	}
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>系统主页</title>
</head>
<body>
	<h3>系统主页（受保护页面）</h3>
	<p>当前登录用户：<%= username %></p>
	<p>这是只有登录后才能访问的业务页面，用于演示过滤器的访问控制。</p>
	<p>
		<a href="<%=request.getContextPath()%>/sucess.jsp">返回登录成功页</a>
		|
		<a href="<%=request.getContextPath()%>/logoutservlet">退出登录</a>
	</p>
</body>
</html>
