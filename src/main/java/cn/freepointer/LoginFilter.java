package cn.freepointer;

import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/home.jsp*")
public class LoginFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//强制转化成HttpServlet才能用重定向、session
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//获取当前请求的相对路径
		String contextPath = req.getContextPath();
		String uri = req.getRequestURI();
		String path = uri.substring(contextPath.length());
		//这些路径放行，防止死循环
		if(path.equals("/login.html")
		        || path.equals("/login")
		        || path.startsWith("/css/")
		        || path.startsWith("/js/")
		        || path.equals("/register.html")
		        || path.equals("/register")){

		        // 放行：交给下一个过滤器/Servlet处理
		        chain.doFilter(request, response);
		        return;
		}
		HttpSession session = req.getSession();
		Object loginUser = session.getAttribute("loginUser");
		if(loginUser != null){
            // ✅ 已登录：放行
            chain.doFilter(request, response);
        }
		else {
			//未登录，重定向到登录页
			resp.sendRedirect(contextPath+"/login.html");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
