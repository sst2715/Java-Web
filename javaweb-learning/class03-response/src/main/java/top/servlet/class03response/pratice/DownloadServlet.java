package top.servlet.class03response.pratice;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String filename = req.getParameter("filename");
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/img/"+filename);
        FileInputStream fis = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "attachment; filename="+filename);
        ServletOutputStream out = resp.getOutputStream();
        byte[] buffer = new byte[1024*8];
        int len=0;
        while((len=fis.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        fis.close();
    }
}
