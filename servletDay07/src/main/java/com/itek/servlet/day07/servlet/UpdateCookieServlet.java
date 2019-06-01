/**
 * @Author xlyu
 * @Date 2019/5/30
 * @Description
 */
package com.itek.servlet.day07.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay07
 * @description:
 * @author: xlyu
 * @create: 2019-05-30 20:16
 **/
@WebServlet(name = "UpdateCookie", urlPatterns = "/update")
public class UpdateCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("area".equals(name)) {
                cookie.setValue("11111111");
                resp.addCookie(cookie);

            }
        }
    }
}
