package cn.freepointer.servlets;

import cn.freepointer.dao.UserDao;
import cn.freepointer.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 1. 接收表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        // 2. 后端基础校验
        if(username == null || username.trim().isEmpty()){
            request.setAttribute("msg","用户名不能为空");
            request.setAttribute("username",username);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        if(password == null || password.trim().isEmpty()){
            request.setAttribute("msg","密码不能为空");
            request.setAttribute("username",username);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
        if(!password.equals(repassword)){
            request.setAttribute("msg","两次输入的密码不一致");
            request.setAttribute("username",username);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        // 3. 调用DAO查重
        UserDao userDao = new UserDao();
        User existUser = userDao.findByUsername(username.trim());
        if(existUser != null){
            request.setAttribute("msg","用户名已被占用");
            request.setAttribute("username",username);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        // 4. 写入数据库完成注册
        User newUser = new User(username.trim(), password.trim());
        newUser.setRole(0);
        int rows = userDao.addUser(newUser);

        if(rows > 0){
        	request.setAttribute("msg", "注册成功！");
            request.setAttribute("type", "success"); // 用来区分成功/失败，前端改颜色
            // 转发回到注册页面
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else{
            // 注册失败：转发回注册页提示
            request.setAttribute("msg","注册失败，请稍后重试");
            request.setAttribute("username",username);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
