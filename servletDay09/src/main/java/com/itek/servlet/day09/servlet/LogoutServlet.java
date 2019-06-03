/**
 * @Author xlyu
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servlet.day09.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay09
 * @description:
 * @author: xlyu
 * @create: 2019-06-03 15:04
 **/
@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long end = System.currentTimeMillis();
        ServletContext sc1= req.getServletContext();

        sc1.setAttribute("end", end);

        resp.sendRedirect("http://localhost:8080/servletDay09/last");
    }
}
