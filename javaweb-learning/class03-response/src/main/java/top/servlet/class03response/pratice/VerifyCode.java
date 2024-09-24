package top.servlet.class03response.pratice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 40;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        // 设置字体
        Font font = new Font("Arial", Font.BOLD, 24);
        g.setFont(font);

        String str = "1234567890abcdefghijklmn";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            // 计算文字的位置
            FontRenderContext frc = g.getFontRenderContext();
            TextLayout layout = new TextLayout(String.valueOf(ch), font, frc);
            int x = (width / 5) * i + (width / 10) - (int)(layout.getBounds().getWidth() / 2);
            int y = height / 2 + (int)(layout.getBounds().getHeight() / 2);
            g.drawString(String.valueOf(ch), x, y);
        }

        // 绘制干扰线
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        // 绘制边框
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);

        // 设置响应类型
        resp.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", resp.getOutputStream());
        g.dispose();
    }
}
