/**
 * @Author xlyu
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servlet.day10.servlet;

import com.itek.servlet.day10.dao.impl.RoleImpl;
import com.itek.servlet.day10.dao.inter.RoleInter;
import com.itek.servlet.day10.module.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: servletDay10
 * @description:
 * @author: xlyu
 * @create: 2019-06-04 16:04
 **/
@WebServlet(name = "RoleServlet", urlPatterns = "*.role")
public class RoleServlet extends HttpServlet {
    RoleInter role = new RoleImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/servletDay10/list.role":
                List<Role> list = role.selectRole();
                req.setAttribute("list", list);
                req.getRequestDispatcher("/WEB-INF/jsp/role/role_list.jsp").forward(req, resp);
                return;
            case "":
                break;
            default:
                break;
        }
    }
}
