/**
 * @Author xlyu
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servlet.day09.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: servletDay09
 * @description:
 * @author: xlyu
 * @create: 2019-06-03 14:35
 **/
@WebFilter(filterName = "Code", urlPatterns = "/*")
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
