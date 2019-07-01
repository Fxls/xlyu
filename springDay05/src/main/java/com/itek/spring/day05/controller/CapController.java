/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 14:37
 **/
@Controller
public class CapController {

    @RequestMapping("cap")
    public String capPage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BufferedImage image = generateCap(req);
        resp.setContentType("image/jpeg");
        OutputStream os = resp.getOutputStream();
        ImageIO.write(image, "jpeg", os);
        os.close();
        return null;
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
        req.getSession().setAttribute("capStr", randomStr);
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
                default:
                    break;
            }
        }
        return stringBuffer.toString();
    }

}
