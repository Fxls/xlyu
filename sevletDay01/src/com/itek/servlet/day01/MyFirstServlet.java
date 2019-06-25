/**
 * @Author xlyu
 * @Date 2019/5/22
 * @Description
 */
package com.itek.servlet.day01;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @program: sevletDay01
 * @description: firstServlet
 * @author: xlyu
 * @create: 2019-05-22 10:11
 **/

public class MyFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println("successful");



        //获取头部文件名
        Enumeration<String> headNames = req.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String str = headNames.nextElement();
            System.out.println(str+"-"+req.getHeader(str));
        }

        /**
         * 输出内容为：（httpHead）
         */

        // 测试getMethod()
        String method = req.getMethod();
        System.out.println(method);//GET


        // 测试getRequestURI()
        String uri = req.getRequestURI();
        System.out.println(uri);///sevletDay01/hello（该uri路径为ip:port后的项目路径对应）

        // 测试setContentType(String type)
        resp.setContentType("text/html;charset=utf-8");


        //给客户端返回数据（请求，响应）
        PrintWriter pw = resp.getWriter();//输出浏览器body里面
        pw.println("<h1>这是一段中文</h1>");
    }
}
