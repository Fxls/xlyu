/**
 * @Author xlyu
 * @Date 2019/5/27
 * @Description
 */
package com.itek.servlet.day04.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: servletDay04
 * @description:
 * @author: xlyu
 * @create: 2019-05-27 10:48
 **/


public class InitParamServlet extends HttpServlet {
    /**
     *
     * 重写父类中的init方法
     *
     */


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(config.getInitParameter("companyName")+"=====");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("destroy=====");
    }
}