package com.itek.servlet.day03.servlet;

import com.itek.servlet.day03.dao.impl.AccountImpl;
import com.itek.servlet.day03.dao.inter.AccountInter;
import com.itek.servlet.day03.module.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//通配符url
@WebServlet(name = "AccountServlet", urlPatterns = "*.do")
/**
 * @Param
 * @description 程序入口
 * @date 2019/5/24 18:55
 * @return
 */

public class AccountServlet extends HttpServlet {


    //serviceshi'yi'ge'xian
    private AccountInter accountInter = new AccountImpl();

    @Override
    /**
     * @Param req={}, resp={}
     * @description 重写的service方法
     * @date 2019/5/24 18:55
     * @return void
     */

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //先把前后端交互的字符集编码调整好
        req.setCharacterEncoding("UTF-8");//前 - 》  后
        resp.setContentType("text/html;charset=UTF-8");//后 - 》 前

        //获取uri路径嗷
        String uri = req.getRequestURI();

        //通过uri进行判断筛选再做出不同的操作
        switch (uri) {
            //增
            case "/servletDay03/account/add.do":
                //将输入的数据传入数据库
                /**
                 * 1、jdbc配置
                 * 2、DAO的创建
                 *  2.1、实体类的创建-
                 *  2.2、接口创建-
                 *  2.3、接口实现类的创建（jdbc连接，重写方法等）-
                 */
                //根据name获取表单的value

                String real_name = req.getParameter("real_name");
                String login_name = req.getParameter("login_name");
                String telephone = req.getParameter("telephone");
                String idcard_no = req.getParameter("idcard_no");
                String status = req.getParameter("status");

                //数据封装进
                accountInter.addAccount(new Account(null, login_name, status, real_name, idcard_no, telephone));
                //重定向跳转值查询页面

                resp.sendRedirect("http://localhost:8080/servletDay03/account/select.do");


                break;
            //删
            case "/servletDay03/account/delete.do":
                //执行删除
                String account_id = req.getParameter("account_id");

                accountInter.deleteAccountById(Integer.parseInt(account_id));

                //删除完成后，重新跳转至查询页
                resp.sendRedirect("http://localhost:8080/servletDay03/account/select.do");
                break;
            //查
            case "/servletDay03/account/select.do":
                List<Account> list = accountInter.selectAccount();

                StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>list</title>\n" +
                        "    <style>\n" +
                        "        table {\n" +
                        "            border: 1px solid black;\n" +
                        "            border-collapse: collapse;\n" +
                        "            margin: 50px auto;\n" +
                        "            text-align: center;\n" +
                        "        }" +
                        "       input{" +
                        "           border:none;" +
                        "           text-align:center;" +
                        "           outline:none;" +
                        "}\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<table border=\"1\">\n" +
                        "    <thead>\n" +
                        "    <tr>\n" +
                        "        <th>用户id</th>\n" +
                        "        <th>用户昵称</th>\n" +
                        "        <th>用户姓名</th>\n" +
                        "        <th>手机号</th>\n" +
                        "        <th>身份证号</th>\n" +
                        "        <th>开通状态</th>\n" +
                        "        <th>操作</th>\n" +
                        "    </tr>\n" +
                        "    </thead>\n" +
                        "    <tbody>\n");
                for (Account account : list) {
                    sb.append("    <tr>\n" +
                            "        <td>" + account.getAccount_id() + "</td>\n" +
                            "        <td>" + account.getLogin_name() + "</td>\n" +
                            "        <td>" + account.getReal_name() + "</td>\n" +
                            "        <td>" + account.getTelephone() + "</td>\n" +
                            "        <td>" + account.getIdcard_no() + "</td>\n" +
                            "        <td>" + account.getStatus() + "</td>\n" +
                            "        <td><a href='http://localhost:8080/servletDay03/account/delete.do?account_id=" + account.getAccount_id() + "'><input type='button' value='删除'></a>&nbsp;" +
                            "<a href='http://localhost:8080/servletDay03/account/change.do?account_id=" + account.getAccount_id() + "&real_name=" + account.getReal_name() + "&login_name=" + account.getLogin_name() + "&telephone=" + account.getTelephone() + "&idcard_no=" + account.getIdcard_no() + "&status=" + account.getStatus() + "'><input type='button' value='修改'></a>" +
                            "</td>\n" +
                            "    </tr>\n");
                }

                sb.append("    </tbody>\n" +
                        "</table>" +
                        "<a href='http://localhost:8080/servletDay03/html/account.html'><button>新增</button></a>" +
                        "</body>\n" +
                        "</html>");

                PrintWriter pw = resp.getWriter();
                pw.println(sb.toString());
                break;
            //改
            case "/servletDay03/account/change.do":


                String account_id2 = req.getParameter("account_id");
////                Integer idGet = Integer.parseInt(account_id2);
                String real_name2 = req.getParameter("real_name");
                String login_name2 = req.getParameter("login_name");
                String telephone2 = req.getParameter("telephone");
                String idcard_no2 = req.getParameter("idcard_no");
                String status2 = req.getParameter("status");


                PrintWriter pw2 = resp.getWriter();
                pw2.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>accountChange</title>\n" +
                        "       <style>" +
                        "       span{" +
                        "display: inline-block;\n" +
                        "            width: 200px;\n" +
                        "            margin-top: 20px;" +
                        "}" +
                        "</style>" +
                        "</head>\n" +
                        "<body>\n" +
                        "<fieldset>\n" +
                        "    <legend>账户信息修改</legend>\n" +
                        "    <form action='http://localhost:8080/servletDay03/account/changeSure.do'>\n" +
                        "        <span>用户ID（无法修改）：</span><input style='outline:none;' readonly type=\"text\" name='account_id' value='" + account_id2 + "'><br/>\n" +
                        "        <span>用户登录名：</span><input type=\"text\" name='login_name' placeholder='" + login_name2 + "'><br/>\n" +
                        "        <span>真实姓名：</span><input type=\"text\" name='real_name' placeholder='" + real_name2 + "'><br/>\n" +
                        "        <span>手机号：</span><input type=\"text\" name='telephone' placeholder='" + telephone2 + "'><br/>\n" +
                        "        <span>身份证号：</span><input type=\"text\" name='idcard_no' placeholder='" + idcard_no2 + "'><br/>\n" +
                        "        <span>开通状态：</span><input type=\"text\" name='status' placeholder='" + status2 + "'><br/>\n" +
//                        "<button onclick=\"f();\">确定</button>"+
                        "        <input type='submit'>" +
                        "    </form>\n" +
                        "</fieldset>\n" +
                        "</body>\n" +
                        "</html>");


                break;
            case "/servletDay03/account/changeSure.do":
                String account_idSure = req.getParameter("account_id");
                Integer idGet = Integer.parseInt(account_idSure);
                String real_nameSure = req.getParameter("real_name");
                String login_nameSure = req.getParameter("login_name");
                String telephoneSure = req.getParameter("telephone");
                String idcard_noSure = req.getParameter("idcard_no");
                String statusSure = req.getParameter("status");

                System.out.println(account_idSure);
                System.out.println(real_nameSure);
                System.out.println(login_nameSure);
                System.out.println(telephoneSure);
                System.out.println(idcard_noSure);
                System.out.println(statusSure);


                accountInter.updateAccountById(new Account(idGet, login_nameSure, statusSure, real_nameSure, idcard_noSure, telephoneSure), idGet);
                resp.sendRedirect("http://localhost:8080/servletDay03/account/select.do");
                break;
        }

    }
}
