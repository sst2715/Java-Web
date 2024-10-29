package top.soft.class05aiaxaxios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 模拟注册用户，判断用户名是否存在
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从请求参数中获取用户名
        String username = req.getParameter("username");
        //2.判断用户名是否存在
        boolean flag = !"admin".equals(username);
        //3.响应查询结果
        resp.getWriter().write(String.valueOf(flag));
    }
}
