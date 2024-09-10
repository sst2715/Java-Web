package top.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import java.io.IOException;

@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求域对象
        //System.out.println("attribute: " + req.getAttribute("msg"));

        // 获取 ServletContext
        ServletContext servletContext = req.getServletContext();
        String info = (String) servletContext.getAttribute("info");
        System.out.println("info: " + info);
    }
}