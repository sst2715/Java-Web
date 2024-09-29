package top.servlet.bookonline.serlvet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.servlet.bookonline.entity.User;
import top.servlet.bookonline.service.UserService;
import top.servlet.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // 检查输入是否为空或空字符串
        if (account == null || account.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                confirmPassword == null || confirmPassword.trim().isEmpty()) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<script>alert('所有字段都是必填的');location.href='/register';</script>");
            return;
        }

        // 检查两次密码是否一致
        if (!password.equals(confirmPassword)) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<script>alert('两次密码输入不一致');location.href='/register';</script>");
            return;
        }

        // 检查用户是否已存在
        User existingUser = userService.findByAccount(account);
        if (existingUser != null) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<script>alert('用户已存在');location.href='/register';</script>");
            return;
        }

        // 创建并保存用户
        User newUser = new User();
        newUser.setAccount(account);
        newUser.setPassword(userService.hashPassword(password));  // 使用 UserServiceImpl 的 hashPassword 方法加密密码

        userService.register(newUser);

        // 注册成功后重定向到登录页面
        resp.sendRedirect("/login");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 直接返回注册页面，通常应该是一个 JSP 或 HTML
        req.getRequestDispatcher("/register.html").forward(req, resp);
    }
}
