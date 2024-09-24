package top.servlet.class03response.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 响应不同的资源类型
 */
@WebServlet("/responseType")
public class responseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "img":
                getImage(req, resp);
                break;
            case "pdf":
                getPdf(req, resp);
                break;
            case "mp4":
                getMp4(req, resp);
                break;
            case "word":
                getWord(req, resp);
                break;
            case "json":
                getJson(req, resp);
                break;
            case "html":
                getHtml(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unsupported type");
                break;
        }
    }

    /**
     * 返回图片资源
     */
    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");
        sendFile(req, resp, "img/123.png");
    }

    /**
     * 返回PDF资源
     */
    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        sendFile(req, resp, "pdf/sample.pdf");
    }

    /**
     * 返回MP4资源
     */
    private void getMp4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("video/mp4");
        sendFile(req, resp, "video/sample.mp4");
    }

    /**
     * 返回Word资源
     */
    private void getWord(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        sendFile(req, resp, "docs/sample.docx");
    }

    /**
     * 返回JSON资源
     */
    private void getJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        sendFile(req, resp, "json/sample.json");
    }

    /**
     * 返回HTML资源
     */
    private void getHtml(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        sendFile(req, resp, "html/sample.html");
    }

    /**
     * 发送文件
     */
    private void sendFile(HttpServletRequest req, HttpServletResponse resp, String filePath) throws IOException {
        String realPath = req.getServletContext().getRealPath("") + "/" + filePath;
        File file = new File(realPath);
        if (!file.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            return;
        }
        try (InputStream ips = new FileInputStream(file);
             ServletOutputStream outputStream = resp.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = ips.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
    }
}
