/**
 * @Author xlyu
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servlet.day05.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay05
 * @description: 使用jsp动态显示当前时间
 * @author: xlyu
 * @create: 2019-05-28 14:01
 **/

@WebServlet(name = "TimeShow", urlPatterns = "/time")
public class TimeShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:8080/servletDay05/jsp/time.jsp");
    }
}
