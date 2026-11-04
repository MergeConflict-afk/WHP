const btn = document.getElementById('loginBtn');
btn.onclick = function () {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    console.log('提交：', username, password);

    // ✅ 用 URLSearchParams 自动编码，替代拼接字符串，避免&=bug
    const formData = new URLSearchParams();
    formData.append("username", username);
    formData.append("password", password);

    fetch("./login", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: formData
    })
    .then(res => res.text())
    .then(ret => {
        console.log(ret);
        // 和后端约定返回标记：success / fail
        if(ret === "success"){
            // 登录成功，前端跳转主页
            location.href = "home.jsp";
        }else{
            // 失败，弹窗提示，保留表单内容
            alert("用户名或密码错误");
        }
    })
    .catch(err=>{
        console.error("请求异常",err);
        alert("网络请求失败");
    })
}
