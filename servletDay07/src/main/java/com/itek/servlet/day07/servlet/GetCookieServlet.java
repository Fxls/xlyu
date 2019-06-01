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
 * @create: 2019-05-30 19:21
 **/
@WebServlet(name = "GetCookie", urlPatterns = "/get")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //使用Cookie数组接收getCookies
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            resp.getWriter().println("nothing");
            return;
        } else {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + cookie.getValue());
            }
        }

    }
}
