/**
 * @Author xlyu
 * @Date 2019/6/19
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
 * @create: 2019-06-19 11:40
 **/
@WebServlet(name = "AccountAddAjaxServlet", urlPatterns = "*.adda")
public class AccountAddAjaxServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/netctoss/name.adda":
                String name = req.getParameter("name");
                boolean isUsed = accountService.selectRealName(name);
                if (name == null || name.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (name.length() > 20) {
                    resp.getWriter().write("*姓名格式错误!");
                } else if (isUsed == true) {
                    resp.getWriter().write("*姓名已经存在，请更换");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/idcard.adda":
                String idcard = req.getParameter("idcard");
                String idcardRex = "[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
                boolean isUsed2 = accountService.selectIdcard(idcard);
                if (idcard == null || idcard.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (!idcard.matches(idcardRex)) {
                    resp.getWriter().write("*身份证号格式错误！");
                } else if (isUsed2 == true) {
                    resp.getWriter().write("*该身份证号已经被注册！");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/loinname.adda":
                String loginnname = req.getParameter("loginname");
                boolean isUsed3 = accountService.selectLoginname(loginnname);
                if (loginnname == null || loginnname.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (loginnname.length() > 15) {
                    resp.getWriter().write("*登录名格式错误！");
                } else if (isUsed3 == true) {
                    resp.getWriter().write("*该登录名已经注册！");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/pwd.adda":
                String pwd = req.getParameter("pwd");
                String pwdRex = "\\d{6}";
                if (pwd == null || pwd.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (!pwd.matches(pwdRex)) {
                    resp.getWriter().write("*密码格式错误！");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/pwdaggain.adda":
                String pwd1 = req.getParameter("pwd");
                String pwdTwice = req.getParameter("pwdTwice");
                if (pwdTwice == null || pwdTwice.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (!pwdTwice.equals(pwd1)) {
                    resp.getWriter().write("*两次密码不一致!");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
            case "/netctoss/tel.adda":
                String tel = req.getParameter("tel");
                String telRex = "1(3|4|5|6|7|8|9)\\d{9}";
                if (tel == null || tel.equals("")) {
                    resp.getWriter().write("*此选项不能为空！");
                } else if (!tel.matches(telRex)) {
                    resp.getWriter().write("*手机号格式错误!");
                } else {
                    resp.getWriter().write("✔");
                }
                break;
        }
    }
}
