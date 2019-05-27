/**
 * @Author xlyu
 * @Date 2019/5/27
 * @Description
 */
package com.itek.servlet.day04.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay04
 * @description:
 * @author: xlyu
 * @create: 2019-05-27 11:43
 **/

@WebServlet(name = "servlet1", urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 获取servlet上下文
//        1、GenericServlet
        ServletContext sc = getServletContext();

        if (sc.getAttribute("totalCount") == null) {
            sc.setAttribute("totalCount",0);
        }
        int totalCount = (Integer) sc.getAttribute("totalCount");
        totalCount++;
        //重新设置访问次数
        sc.setAttribute("totalCount", totalCount);
        System.out.println("访问次数：" + totalCount);

    }
}

