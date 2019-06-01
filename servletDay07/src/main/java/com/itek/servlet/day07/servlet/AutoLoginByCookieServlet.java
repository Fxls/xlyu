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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay07
 * @description:
 * @author: xlyu
 * @create: 2019-05-31 19:22
 **/

@WebServlet(name = "AutoLogin", urlPatterns = "*.log")
public class AutoLoginByCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String uri = req.getRequestURI();


        switch (uri) {
            case "/servletDay07/first.log":

                //获取用户名密码
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");

                //假设用户第一次登录，将用户名密码添加进cookie(注意编码问题)
                Cookie cookie_name = new Cookie("name", URLEncoder.encode(name, "UTF-8"));
                Cookie cookie_pwd = new Cookie("pwd", URLEncoder.encode(pwd, "utf-8"));

                System.out.println(name);
                System.out.println(pwd);

                //设置cookie的生存的时间(一个月)
                cookie_name.setMaxAge(60 * 60 * 24 * 30);
                cookie_pwd.setMaxAge(60 * 60 * 24 * 30);

                resp.addCookie(cookie_name);
                resp.addCookie(cookie_pwd);

                req.setAttribute("name", name);
                req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);


                break;

            /**
             * 检测cookie是否存在，如果不存在则返回case1，如果存在执行自动登录
             */
            case "/servletDay07/check.log":
                List<String> info = new ArrayList<>();
                Cookie[] cookies = req.getCookies();
                //遍历cookies进行逻辑判断
                for (Cookie cookie : cookies) {
                    if ("name".equals(cookie.getName())) {
                        //进入这个分支说明存在名为name的cookie
                        String getName = URLDecoder.decode(cookie.getValue());//decoder

                        System.out.println(getName);
                        req.setAttribute("name", getName);
                        //转发jsp
                        req.getRequestDispatcher("/jsp/autoLogin.jsp").forward(req, resp);
                        info.add(getName);
                    } else if ("pwd".equals(cookie.getName())) {
                        String getPwd = URLDecoder.decode(cookie.getValue());
                        System.out.println(getPwd);
                        req.setAttribute("pwd", getPwd);
                        req.getRequestDispatcher("/jsp/autoLogin.jsp").forward(req, resp);
                        info.add(getPwd);
                    } else {
                        System.out.println("没有你要的字段，说明你还从未登陆过该网页");
                        req.getParameter("name");
                        req.getParameter("pwd");
                        System.out.println(req.getParameter("name"));
                        System.out.println(req.getParameter("pwd"));
                        resp.sendRedirect("http://localhost:8080/servletDay07/first.log?name=" + req.getParameter("name") + "&pwd=" + req.getParameter("pwd") + "");
                        return;
                    }
                }


                break;

        }


    }
}

