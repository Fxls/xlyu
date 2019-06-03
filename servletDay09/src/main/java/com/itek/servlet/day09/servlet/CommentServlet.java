/**
 * @Author xlyu
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servlet.day09.servlet;

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
 * @create: 2019-06-03 14:08
 **/
@WebServlet(name = "CommentServlet", urlPatterns = "/comm")
public class CommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入CommentServlet");
        String comment = req.getParameter("comment");
        resp.getWriter().println("您发表的评论已经<font color='red'>"+comment+"</font>发表成功！");

    }
}
