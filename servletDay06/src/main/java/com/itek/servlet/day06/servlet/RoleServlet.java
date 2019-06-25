/**
 * @Author xlyu
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servlet.day06.servlet;

import com.itek.servlet.day06.dao.impl.RoleImpl;
import com.itek.servlet.day06.dao.inter.RoleInter;
import com.itek.servlet.day06.module.Role;
import com.itek.servlet.day06.service.impl.RoleServiceImpl;
import com.itek.servlet.day06.service.inter.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @program: servletDay06
 * @description:
 * @author: xlyu
 * @create: 2019-05-29 14:26
 **/
@WebServlet(name = "Role", urlPatterns = "*.role")
public class RoleServlet extends HttpServlet {
    private RoleService rs = new RoleServiceImpl();
    private RoleInter roleInter = new RoleImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/text/charset=utf-8");

        String uri = req.getRequestURI();
        switch (uri) {
            case "/servletDay06/Role/list.role":
                List<Role> roles = rs.getRoleInfo();

                //绑定数据
                req.setAttribute("roles", roles);

                //实现转发
                /**
                 * getRequestDispatcher()获取转发器
                 * forward(req,resp)转发
                 */
                req.getRequestDispatcher("/role/role_list.jsp").forward(req, resp);

                return;

            case "/servletDay06/Role/add.role":
                String roleName = req.getParameter("roleName");
                String[] powerNames = req.getParameterValues("powerId");//value数组

                System.out.println(roleName);
                System.out.println(Arrays.toString(powerNames));
                roleInter.addRole(roleName);
                roleInter.selectId(roleName);//id
                System.out.println(roleInter.selectId(roleName));
                roleInter.addN_role_power(roleInter.selectId(roleName), powerNames);//Interger,String [] arr


                resp.sendRedirect("http://localhost:8080/servletDay06/Role/list.role");
                return;

            case "/servletDay06/Role/modi.role":
                String nameModi = req.getParameter("powerNames");//所拥有的所有权限
                String nameRole = req.getParameter("name");//角色

                System.out.println(nameModi);
                System.out.println(nameRole);


                String[] strArr = nameModi.split(",");


                req.setAttribute("roleName", nameRole);
                req.setAttribute("powerNames", strArr);
                req.getRequestDispatcher("/role/role_modi.jsp").forward(req, resp);
//                resp.sendRedirect("https://www.baidu.com");


                return;
//
            case "/servletDay06/Role/delete.role":

                //删除（只需要删除role表中的字段即可）

                String deleteId = req.getParameter("deleteId");
                roleInter.deleteById(Integer.parseInt(deleteId));


                resp.sendRedirect("http://localhost:8080/servletDay06/Role/list.role");
                return;
            default:
                //异常界面设置
                resp.sendRedirect("chrome://dino");
                break;

        }
    }
}
