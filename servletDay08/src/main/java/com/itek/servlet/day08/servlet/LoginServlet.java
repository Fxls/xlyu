/**
 * @Author xlyu
 * @Date 2019/6/1
 * @Description
 */
package com.itek.servlet.day08.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @program: servletDay08
 * @description:
 * @author: xlyu
 * @create: 2019-06-01 13:35
 **/

@WebServlet(name = "LoginServlet", urlPatterns = "*.log")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession s = req.getSession();
        HttpSession sOfCap = req.getSession();
        String uri = req.getRequestURI();
        switch (uri) {
            case "/servletDay08/check.log":
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");
                String captcha = req.getParameter("captcha");
                if (!captcha.equals((String) sOfCap.getAttribute("cap"))) {
                    resp.sendRedirect("/servletDay08/error.log");
                    return;
                }
                s.setAttribute("isLogin", true);
                if ("xlyu".equals(name) && "123456".equals(pwd)) {
                    //进入此分支说明用户名，密码正确
                    s.setMaxInactiveInterval(60);
                    //进入首页
                    resp.sendRedirect("/servletDay08/index.log");
                } else {
                    resp.sendRedirect("/servletDay08/login.log");
                }

                break;
            case "/servletDay08/login.log":
                //使用转发访问web-inf下的jsp
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
                break;
            case "/servletDay08/index.log":
                if (s.getAttribute("isLogin") != null && (Boolean) s.getAttribute("isLogin") == true) {
                    req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/servletDay08/login.log");
                }
                break;
            case "/servletDay08/captcha.log":
                //验证码环节
                BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
                Graphics g = image.getGraphics();
                Random r = new Random();
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

                //验证码背景抠图
                g.fillRect(0, 0, 150, 40);
                String randomStr = generateRandomString(5);
                sOfCap.setAttribute("cap", randomStr);


                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                g.setFont(new Font("微软雅黑", Font.BOLD, 30));
                g.drawString(randomStr, 5, 30);

                for (int i = 1; i <= 8; i++) {
                    g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                    g.drawLine(r.nextInt(150), r.nextInt(40), r.nextInt(150), r.nextInt(40));
                }

                resp.setContentType("image/jpeg");
                OutputStream os = resp.getOutputStream();

                ImageIO.write(image, "jpeg", os);
                os.close();


                break;
            case "/servletDay08/error.log":
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
                break;
        }


    }

    /**
     * @return
     * @Param
     * @description 生成随机字符串
     * @date 2019/6/1 14:29
     */

    private String generateRandomString(int length) {
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
