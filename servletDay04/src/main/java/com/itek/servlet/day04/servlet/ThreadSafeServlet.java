/**
 * @Author xlyu
 * @Date 2019/5/27
 * @Description
 */
package com.itek.servlet.day04.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: servletDay04
 * @description:
 * @author: xlyu
 * @create: 2019-05-27 15:32
 **/

@WebServlet(name = "safeTest", urlPatterns = "/safeTest")
public class ThreadSafeServlet extends HttpServlet {
//    public static String name = "Hello";   //静态变量，可能发生线程安全问题
    int i;  //实例变量，可能发生线程安全问题
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("servlet初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        synchronized (this) {
            System.out.println("%s：%s[%s]\n" + Thread.currentThread().getName() + "**" + i + "**" + format.format(new Date()));
            i++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("%s：%s[%s]\n" + Thread.currentThread().getName() + "**" + i + "**" + format.format(new Date()));
//        }
        PrintWriter pw = resp.getWriter();
        pw.println("<h1>" + i + "</h1>");

    }
}
