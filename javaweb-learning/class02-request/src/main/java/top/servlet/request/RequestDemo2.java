package top.servlet.request;


import com.sun.source.tree.WhileLoopTree;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        String header =req.getHeader("user-agent");
        if (header.contains("Edg")) {
            System.out.println("Edge 浏览器");
            
        } else if(header.contains("Chrome")){
            System.out.println("chrome 浏览器");
            
        }
    }
}//获取请求头数据
