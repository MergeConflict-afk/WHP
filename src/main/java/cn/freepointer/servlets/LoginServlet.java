package cn.freepointer.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || username.trim().isEmpty()||password == null || password.trim().isEmpty()) {
			response.getWriter().write("fail");
			return;
		}
		
		HttpSession session = request.getSession();
		if("admin".equals(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);//把username存入会话
			response.getWriter().write("success");//登录成功
		}
		else {
			response.getWriter().write("fail");
		}
		
		
	}

}
