/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.servlet;

import com.iek.netctoss.module.Account;
import com.iek.netctoss.service.AccountService;
import com.iek.netctoss.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-11 10:22
 **/
@WebServlet(name = "AccountServlet", urlPatterns = "*.acc")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/netctoss/list.acc":
                List<Account> accounts = accountService.getAccount();

                req.setAttribute("accounts", accounts);

                req.getRequestDispatcher("/WEB-INF/jsp/account/account_list.jsp").forward(req, resp);
                break;
            case "/netctoss/update.acc":
                break;

        }
    }
}
