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
 * @create: 2019-06-04 14:39
 **/
@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = 1;
        double b = 0.5;
        boolean yes = true;
        boolean no = false;
        String n = null;
        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("yes", yes);
        req.setAttribute("no", no);
        req.setAttribute("n", n);
        req.getRequestDispatcher("/WEB-INF/jsp/ELtest.jsp").forward(req, resp);
    }
}
