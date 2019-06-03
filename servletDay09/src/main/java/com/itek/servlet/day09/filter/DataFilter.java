/**
 * @Author xlyu
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servlet.day09.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: servletDay09
 * @description:
 * @author: xlyu
 * @create: 2019-06-03 15:12
 **/
@WebFilter(filterName = "DataFilter", urlPatterns = "/last")
public class DataFilter implements Filter {
    ServletContext sc3;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    sc3 = servletRequest.getServletContext();
        /**
         * 1、保存url
         * 2、请求参数
         * 3、请求方法
         * 4、请求响应时间
         */
        String uri = (String) sc3.getAttribute("uri");
        String[] arguments = (String[]) sc3.getAttribute("arguments");
        String method = (String) sc3.getAttribute("method");
        Long time = (Long) sc3.getAttribute("end") - (Long) sc3.getAttribute("start");
//
        System.out.println(uri);
        System.out.println(Arrays.toString(arguments));
        System.out.println(method);
        System.out.println(time);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
