package cn.freepointer.servlets;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import cn.freepointer.entity.User;
import cn.freepointer.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("不支持GET方式访问");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/plain;charset=UTF-8");

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    // 判空
	    if(username == null || username.trim().isEmpty()
	            || password == null || password.trim().isEmpty()){
	        response.getWriter().write("fail");
	        return;
	    }

	    // 调用DAO查询用户
	    UserDao userDao = new UserDao();
	    User user = userDao.findByUsername(username.trim());

	    HttpSession session = request.getSession();
	    // 用户存在 且 密码匹配
	    if(user != null && user.getPassword().equals(password.trim())){
	        session.setAttribute("loginUser", username);
	        session.setAttribute("loginRole", user.getRole());
	        if(user.getRole()==1)
	        {
	        	session.setAttribute("class","管理员");
	        }else {
	        	session.setAttribute("class", "普通用户");
	        }
	        response.getWriter().write("success");
	    }else{
	        // 登录失败清理残留
	        session.removeAttribute("loginUser");
	        response.getWriter().write("fail");
	    }
	}


}
