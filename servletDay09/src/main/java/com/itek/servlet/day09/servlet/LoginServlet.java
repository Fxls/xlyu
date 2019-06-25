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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: servletDay09
 * @description:
 * @author: xlyu
 * @create: 2019-06-03 14:48
 **/
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    ServletContext sc;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //开始
        Long start = System.currentTimeMillis();
        req.getSession();
        //uri地址获取
        String uri = req.getRequestURI();
        //请求参数
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        //请求方式
        String method = req.getMethod();

//        System.out.println(name + pwd + method);
        String[] arguments = {name, pwd};


        //使用上下文绑定
        sc = req.getServletContext();
        sc.setAttribute("uri", uri);
        sc.setAttribute("name",name);
        sc.setAttribute("arguments", arguments);
        sc.setAttribute("method", method);
        sc.setAttribute("start",start);

        //转发到首页
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);


    }
}
