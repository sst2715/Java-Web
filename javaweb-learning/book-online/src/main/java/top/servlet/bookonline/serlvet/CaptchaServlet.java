package top.servlet.bookonline.serlvet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/generateCaptcha")
public class CaptchaServlet extends HttpServlet {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captcha = generateCaptcha(6);
        req.getSession().setAttribute("captcha", captcha);

        System.out.println("Generated Captcha: " + captcha);

        BufferedImage image = createCaptchaImage(captcha);
        resp.setContentType("image/png");
        ImageIO.write(image, "png", resp.getOutputStream());
    }

    private String generateCaptcha(int length) {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captcha.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return captcha.toString();
    }

    private BufferedImage createCaptchaImage(String captcha) {
        int width = 120; // 增加宽度
        int height = 50; // 增加高度
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 设置背景颜色
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);

        // 设置字体和颜色
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        // 计算字符串绘制的中心位置
        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(captcha);
        int x = (width - stringWidth) / 2; // 水平居中
        int y = (height + fm.getAscent()) / 2; // 垂直居中

        // 绘制验证码
        g.drawString(captcha, x, y);
        g.dispose();

        return image;
    }

}

