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
 * @create: 2019-05-30 18:40
 **/
@WebServlet(name = "FirstCookie", urlPatterns = "/login")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        //创建Cookie对象(Sting 名，String 值)

        String name = req.getParameter("name");
        String area = req.getParameter("area");
        Cookie c_name = new Cookie("name", name);
        Cookie c_area = new Cookie("area", area);
        System.out.println(name+area);//xlyuhefei

        //调用addCookie方法
        resp.addCookie(c_name);
        resp.addCookie(c_area);

    }
}
