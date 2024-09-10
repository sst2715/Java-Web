package top.servlet.request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestDemo6 被请求");
        resp.getWriter().write("RequestDemo6");
        req.setAttribute("msg","hello");

        ServletContext context = req.getServletContext();
        context.setAttribute("info","hello，word");
    }
}//获取域对象的值