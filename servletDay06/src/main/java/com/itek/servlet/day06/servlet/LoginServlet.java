/**
 * @Author xlyu
 * @Date 2019/5/30
 * @Description
 */
package com.itek.servlet.day06.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay06
 * @description:
 * @author: xlyu
 * @create: 2019-05-30 15:31
 **/
@WebServlet(name = "Login", urlPatterns = "*.login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        if ("/servletDay06/a.login".equals(uri)) {
            String str = "";
            req.setAttribute("str", str);
            req.getRequestDispatcher("login.jsp").forward(req, resp);


        }
    }
}
