package com.itek.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "CreateServlet1", urlPatterns = "/servlet1")
public class CreateServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
//        String[] strArr = req.getParameterValues("username");
//        System.out.println(Arrays.toString(strArr));

        String username2 = req.getParameter("username2");
        String[] strArrOfHobby = req.getParameterValues("hobby");
        System.out.println(username2 + "\n" + Arrays.toString(strArrOfHobby));

        PrintWriter pw = resp.getWriter();
        pw.println("你的名字是："+username2);
        pw.println("你的爱好有："+Arrays.toString(strArrOfHobby));

    }
}
