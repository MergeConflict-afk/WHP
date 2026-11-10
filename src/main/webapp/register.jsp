<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-box">
    <h2>用户注册</h2>

<%
String msg = (String) request.getAttribute("msg");
String type = (String) request.getAttribute("type");
if(msg != null){
    String color = "red";
    if("success".equals(type)){
        color = "green";
    }
%>
    <p style="color:<%=color%>; text-align:center; font-size:14px;"><%=msg%></p>
<%
}
%>


    <form action="register" method="post">
        <div class="item">
            <label>用户名</label>
            <input type="text" name="username" placeholder="请输入用户名" 
                   value="<%= request.getAttribute("username")!=null?request.getAttribute("username"):"" %>">
        </div>
        <div class="item">
            <label>密码</label>
            <input type="password" name="password" placeholder="请输入密码">
        </div>
        <div class="item">
            <label>确认密码</label>
            <input type="password" name="repassword" placeholder="请再次输入密码">
        </div>
        <button class="common_bt" type="submit">注册</button>
    </form>

    <a href="login.html" class="register-link">已有账号？去登录</a>
</div>
</body>
</html>
