/**
 * @Author xlyu
 * @Date 2019/6/6
 * @Description
 */
package com.iek.netctoss.servlet;


import com.iek.netctoss.commons.ServiceResult;
import com.iek.netctoss.module.User;
import com.iek.netctoss.service.LoginService;
import com.iek.netctoss.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-06 16:40
 **/
@WebServlet(name = "Login", urlPatterns = "*.log")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        switch (uri) {
            case "/netctoss/login.log":
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
                break;
            case "/netctoss/check.log":

                String loginName = req.getParameter("username");
                session.setAttribute("loginName",loginName);
                String loginPwd = req.getParameter("pwd");
                session.setAttribute("loginPwd",loginPwd);
                String capStr = req.getParameter("cap");
                session.setAttribute("capStr",capStr);
                System.out.println(loginName + "****" + loginPwd+"*****"+capStr);
                System.out.println(session.getAttribute("cap")+"********");

                req.setAttribute("loginName", loginName);
                req.setAttribute("loginPwd", loginPwd);

                ServiceResult<User> result = loginService.result(loginName, loginPwd, capStr);
                if (result.isSuccess()) {
                    session.setAttribute("loginedUser", result.getData());
                    resp.sendRedirect("/netctoss/index.log");
                } else {
                    resp.sendRedirect("/netctoss/login.log?msg=" + result.getMsg());
                    System.out.println(result.getMsg());
                }
                break;
            case "/netctoss/index.log":
                req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
                break;
        }
    }
}
