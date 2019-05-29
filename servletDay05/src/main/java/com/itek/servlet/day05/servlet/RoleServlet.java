/**
 * @Author xlyu
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servlet.day05.servlet;

import com.itek.servlet.day05.dao.impl.RoleImplent;
import com.itek.servlet.day05.dao.interFace.RoleInterface;
import com.itek.servlet.day05.module.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: servletDay05
 * @description:
 * @author: xlyu
 * @create: 2019-05-28 15:19
 **/

@WebServlet(name = "Role", urlPatterns = "*.do")
public class RoleServlet extends HttpServlet {
    private RoleInterface ri = new RoleImplent();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();

        switch (uri) {

            case "/servletDay05/role/select.do":
                resp.sendRedirect("http://localhost:8080/servletDay05/jsp/role/role_list.jsp");
                break;

            case "/servletDay05/role/add.do":
                String name = req.getParameter("name");
                String[] priviege = req.getParameterValues("priviege");
                System.out.println(name);
                String pValue = "";
                System.out.println(Arrays.toString(priviege));
                for (int i = 0; i < priviege.length; i++) {
                    pValue += priviege[i];
                }
                ri.addRole(new Role(null, name, pValue));
                resp.sendRedirect("http://localhost:8080/servletDay05/jsp/role/role_list.jsp");
                break;

            case "/servletDay05/role/delete.do":
                String nameDel = req.getParameter("id");
                System.out.println(nameDel);
                ri.deleteRole(Integer.parseInt(nameDel));
                resp.sendRedirect("http://localhost:8080/servletDay05/jsp/role/role_list.jsp");
                break;

            case "/servletDay05/role/update2.do":
                Integer idHidden = Integer.parseInt(req.getParameter("idHidden"));
                String nameUpdate = req.getParameter("name");
                String[] priviegeUp = req.getParameterValues("priviege");
                System.out.println(idHidden);
                System.out.println(nameUpdate);
                System.out.println(Arrays.toString(priviegeUp));

                String pValue2 = "";

                for (int i = 0; i < priviegeUp.length; i++) {
                    pValue2 += priviegeUp[i];
                }
                ri.updateRole(new Role(idHidden, nameUpdate, pValue2), idHidden);
                resp.sendRedirect("http://localhost:8080/servletDay05/jsp/role/role_list.jsp");
                break;
        }
    }
}
