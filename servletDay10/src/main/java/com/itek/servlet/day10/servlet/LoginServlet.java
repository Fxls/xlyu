/**
 * @Author xlyu
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servlet.day10.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay10
 * @description:
 * @author: xlyu
 * @create: 2019-06-04 15:15
 **/
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/getPara.jsp").forward(req, resp);
    }
}
