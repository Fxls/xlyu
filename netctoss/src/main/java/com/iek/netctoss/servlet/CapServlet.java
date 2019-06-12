/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.servlet;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @program: netctoss
 * @description: 验证码生成
 * @author: xlyu
 * @create: 2019-06-10 14:56
 **/
@WebServlet(name = "Cap", urlPatterns = "/cap")
public class CapServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码制作方法generateCap();
        BufferedImage image = generateCap(req);

        //设置页面输出格式
        resp.setContentType("image/jpeg");
        OutputStream os = resp.getOutputStream();
        ImageIO.write(image, "jpeg", os);
        os.close();
    }

    private static BufferedImage generateCap(HttpServletRequest req) {
        BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

        //验证码背景抠图
        g.fillRect(0, 0, 150, 40);
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.setFont(new Font("微软雅黑", Font.BOLD, 30));
        String randomStr = generateRandomString(5);
        req.getSession().setAttribute("capStr",randomStr);
        System.out.println(randomStr);

        g.drawString(randomStr, 5, 30);

        for (int i = 1; i <= 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(150), r.nextInt(40), r.nextInt(150), r.nextInt(40));
        }
        return image;
    }

    private static String generateRandomString(int length) {
        Random r = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int tip = r.nextInt(3);
            long result = 0;
            switch (tip) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    stringBuffer.append((char) result);
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    stringBuffer.append((char) result);
                    break;
                case 2:
                    stringBuffer.append(new Random().nextInt(10));
                    break;
            }
        }
        return stringBuffer.toString();
    }
}
