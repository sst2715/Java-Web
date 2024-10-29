package top.servlet.bookonline.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // 指定过滤器的 URL 匹配
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 可以进行初始化操作
        System.out.println("初始化 LoginFilter");
    }

    @Override
    public void destroy() {
        System.out.println("销毁 LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String[] urls = {"/images/", "/css/", "/login.html", "/login-page", "/login","/generateCaptcha"};

        // 获取请求路径
        String requestUrl = request.getRequestURI(); // 使用 getRequestURI() 获取请求路径

        for (String url : urls) {
            if (requestUrl.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse); // 继续过滤链
                return;
            }
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse); // 用户已登录，继续过滤链
        } else {
            request.getRequestDispatcher("/login.html").forward(servletRequest, servletResponse); // 未登录，转发到登录页面
        }
    }
}
