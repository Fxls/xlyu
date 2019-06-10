/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.filter;

import com.iek.netctoss.module.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 14:28
 **/
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println(uri);
        //非登录路径进行拦截
        if (!"/netctoss/login.log".equals(uri) &&
                !"/netctoss/check.log".equals(uri) &&
                !uri.startsWith("/netctoss/images") &&
                !uri.startsWith("/netctoss/styles")) {
            //根据session中的数据判定该用户是否已经登录过
            User loginedUser = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("loginedUser");
            if (loginedUser == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/netctoss/login.log");

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
