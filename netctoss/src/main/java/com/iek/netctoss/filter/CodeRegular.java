/**
 * @Author xlyu
 * @Date 2019/6/6
 * @Description
 */
package com.iek.netctoss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-06 16:41
 **/
/**
 * @Param
 * @description 过滤器：用于设置web的字符集
 * @date 2019/6/6 16:46
 * @return
 */

@WebFilter(filterName = "AFilter", urlPatterns = "/*")
public class CodeRegular implements Filter {


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
