/**
 * @Author xlyu
 * @Date 2019/5/31
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
import java.net.URLDecoder;

/**
 * @program: servletDay07
 * @description:
 * @author: xlyu
 * @create: 2019-05-31 18:52
 **/

@WebServlet(name = "CharServlet", urlPatterns = "/charset")
public class CharServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Cookie[] cookies = req.getCookies();

        //遍历cookie数组
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                System.out.println(URLDecoder.decode(cookie.getValue()));

            }
        }
    }
}
