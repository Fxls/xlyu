package com.itek.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

@WebServlet(name = "GogGirlServlet", urlPatterns = "/godGirl")
public class GogGirlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name  = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.println("你好，"+name+"女神");
    }
}
