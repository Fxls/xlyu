/**
 * @Author xlyu
 * @Date 2019/5/31
 * @Description
 */
package com.itek.servlet.day08.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: servletDay08
 * @description: session对象测试
 * @author: xlyu
 * @create: 2019-05-31 09:50
 **/

@WebServlet(name = "SessionServlet", urlPatterns = "/some")
public class SomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        //第一访问服务器，对session进行数据绑定
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 1);
            resp.getWriter().println("你访问服务器1次！");
        } else {
            int count = (int) session.getAttribute("count");
            session.setAttribute("count", ++count);
            resp.getWriter().println("你已经访问服务器" + count + "次！");
        }
    }
}
