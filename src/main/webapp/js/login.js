/**
 * 
 */
const btn = document.getElementById('loginBtn');
btn.onclick = function () {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    console.log('提交：', username, password);

    // 后续对接后端示例，替换这里
    /*
    fetch("/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "username=" + username + "&password=" + password
    })
    .then(res=>res.text())
    .then(ret=>{
        console.log(ret);
    })
    */
}
