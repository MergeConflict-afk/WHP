<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果</title>
</head>
<body>
<%
    // 设置编码，防止中文乱码
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String pwd = request.getParameter("pwd");
    String email = request.getParameter("email");

    // 判空
    if(username == null || username.trim().isEmpty()){
        out.print("用户名不能为空");
        return;
    }
    username = username.trim();

    // 业务判断
    if(username.startsWith("user")){
        out.print("<h3>该用户名已被注册</h3>");
        out.print("客户端提交的控件信息：<br/>");
        out.print("用户名：" + username + "<br/>");
        out.print("密码：" + pwd + "<br/>");
        out.print("邮箱：" + email + "<br/>");
    }else if("admin".equals(username)){
        out.print("<h3>欢迎您，管理员</h3>");
    }else{
        out.print("<h3>注册成功</h3>");
    }
%>
</body>
</html>
