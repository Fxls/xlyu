/**
 * @Author xlyu
 * @Date 2019/6/17
 * @Description
 */
package com.iek.netctoss.servlet;

import com.iek.netctoss.service.inter.AccountService;
import com.iek.netctoss.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-17 20:18
 **/
@WebServlet(name = "AjaxOfModi", urlPatterns = "*.ajax")
public class AccountModiAjaxServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/netctoss/modiname.ajax":
                String realName = req.getParameter("realName");
                if (realName == null || realName.equals("")) {
                    resp.getWriter().write("*请输入内容");
                } else if (realName.length() > 18) {
                    resp.getWriter().write("*请保证输入长度在18以内");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/modiOldpwd.ajax":
                String id = req.getParameter("id");
                String oldpwd = req.getParameter("oldpwd");
                String selectPwd = accountService.getPwd(id);
                if (oldpwd == null || oldpwd.equals("")) {
                    resp.getWriter().write("*请输入您的旧密码");
                } else if (!selectPwd.equals(oldpwd)) {
                    resp.getWriter().write("*你输入的旧密码错误，请重新输入");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/modiNewPwd.ajax":
                String newpwd = req.getParameter("newpwd");
                if (newpwd == null || newpwd.equals("")) {
                    resp.getWriter().write("*请输入您要设置的新密码");
                } else if (newpwd.length() > 6) {
                    resp.getWriter().write("*请输入六个字符以内的新密码");
                } else {
                    resp.getWriter().write("✔新密码可用");
                }
                break;
            case "/netctoss/modipwdAgain.ajax":
                String pwdagain = req.getParameter("pwdagain");
                String firstpwd = req.getParameter("firstpwd");
                if (pwdagain == null || pwdagain.equals("")) {
                    resp.getWriter().write("*请输入");
                } else if (!pwdagain.equals(firstpwd)) {
                    resp.getWriter().write("*两次输入必须一样");
                } else {
                    resp.getWriter().write("✔");
                }

                break;
            case "/netctoss/modiTelephoneAjax.ajax":
                String telephone = req.getParameter("telephone");
                String teleReg = "1([38]\\d|5[0-35-9]|7[3678])\\d{8}";

                if (!telephone.matches(teleReg)) {
                    resp.getWriter().write("*请输入正确的手机号格式");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/idcardOfOther.ajax":
                String id1 = req.getParameter("id");
                String idcardNo = accountService.getReIdNo(id1);
                if (idcardNo == null) {
                    resp.getWriter().write("");
                } else {
                    resp.getWriter().write(idcardNo);
                }
                break;
            case "/netctoss/emailAjax.ajax":
                String email = req.getParameter("email");
                String emailReg = "[\\w]+(\\.[\\w]+)*@[\\w]+(\\.[\\w])+";
                if (email == null || email.equals("")) {
                    resp.getWriter().write("");
                } else if (!email.matches(emailReg)) {
                    resp.getWriter().write("*请输入正确格式的邮箱地址");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/zipAjax.ajax":
                String zip = req.getParameter("zip");
                String zipRex = "[0-9]{6}";
                if (zip == null || zip.equals("")) {
                    resp.getWriter().write("");
                } else if (!zip.matches(zipRex)) {
                    resp.getWriter().write("*请输入正确格式的邮编");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/qqAjax.ajax":
                String qq = req.getParameter("qq");
                String qqRex = "[1-9][0-9]{4,14}";
                if (qq == null || qq.equals("")) {
                    resp.getWriter().write("");
                } else if (!qq.matches(qqRex)) {
                    resp.getWriter().write("*请输入正确格式的qq");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/dele.ajax":
                String id2 = req.getParameter("id");
                String status = req.getParameter("status");
                System.out.println(id2 + "+1");
                System.out.println(status + "+2");
                boolean isSuccess = accountService.updateStatus(Integer.parseInt(id2), status);
                if (isSuccess == true) {
                    resp.getWriter().write("删除成功");
                }

                break;

        }
    }
}
