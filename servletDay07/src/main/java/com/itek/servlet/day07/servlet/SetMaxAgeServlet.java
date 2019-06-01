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
import java.net.URLEncoder;

/**
 * @program: servletDay07
 * @description:
 * @author: xlyu
 * @create: 2019-05-31 18:43
 **/

@WebServlet(name = "SetAge", urlPatterns = "/max")
public class SetMaxAgeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");


        String encodeStr = URLEncoder.encode("马云", "utf-8");
        Cookie cookie = new Cookie("name", encodeStr);
        System.out.println(encodeStr);//输出乱乱字符（decoder）


        /**
         * 设置cookie的存活时间
         */
        cookie.setMaxAge(6);
        resp.addCookie(cookie);
    }
}
