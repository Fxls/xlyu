/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.servlet;

import com.iek.netctoss.commons.AccountStatus;
import com.iek.netctoss.commons.Const;
import com.iek.netctoss.module.Account;
import com.iek.netctoss.service.inter.AccountService;
import com.iek.netctoss.service.impl.AccountServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

            //分页查询

            case "/netctoss/list.acc":

                String pageNoGet = req.getParameter("pageNo");
                String realName = req.getParameter("realName");
                String idcardNo = req.getParameter("idcardNo");
                String loginName = req.getParameter("loginName");
                String status = req.getParameter("status");

                Account account = new Account(realName, idcardNo, loginName, status);


                int endPage = accountService.getAccountEndPage();
                int likeEndPage = accountService.getLikeAccountEndPage(account);

                int pageNo = 1;

                if (pageNoGet != null && !"".equals(pageNoGet)) {

                    pageNo = Integer.parseInt(pageNoGet);

                }

                List<Account> accounts = accountService.getAccountByPage(Const.PAGE_SIZE, pageNo, account);


                req.setAttribute("accounts", accounts);

                req.setAttribute("current", pageNo);
                if (idcardNo != null || realName != null || loginName != null) {
                    req.setAttribute("endPage", likeEndPage);
                    System.out.println(likeEndPage + "like");
                } else {
                    req.setAttribute("endPage", endPage);
                    System.out.println(endPage + "end");
                }

                req.getRequestDispatcher("/WEB-INF/jsp/account/account_list.jsp").forward(req, resp);

                break;
            case "/netctoss/todetail.acc":
                String id1 = req.getParameter("id");
                String realNameDetail = req.getParameter("detail");
                System.out.println(realNameDetail + "000");
                List<Account> list = accountService.getDetailInfo(realNameDetail);

                System.out.println("detail" + list.get(0).getId());
                req.setAttribute("detailInfo", list.get(0));
                req.getRequestDispatcher("/WEB-INF/jsp/account/account_detail.jsp").forward(req, resp);
                break;
            case "/netctoss/state.acc":
                //取参
                String id = req.getParameter("id");
                String status1 = req.getParameter("status");

                if (id == null || id.equals("") || status1 == null || status1.equals("")) {
                    resp.getWriter().write("请求参数错误");
                    return;
                }

                AccountStatus[] vals = AccountStatus.values();
                boolean invalidStatus = false;
                for (AccountStatus val : vals) {
                    if (val.getStatus().equals(status1)) {
                        invalidStatus = true;
                    }
                }

                if (!invalidStatus) {
                    resp.getWriter().write("请求参数错误");
                }


                boolean isSuccess = accountService.updateStatus(Integer.parseInt(id), status1);
                if (isSuccess) {
                    //TODO success
                    resp.getWriter().write("成功!");
                } else {
                    //TODO defeat
                    resp.getWriter().write("失败!");
                }
                break;
            case "/netctoss/get/state.acc":
                resp.getWriter().write(AccountStatus.toJSONStr());
                return;

            case "/netctoss/update.acc":
                String id2 = req.getParameter("id");

                List<Account> accounts1 = accountService.getInfoById(id2);
                req.setAttribute("modi", accounts1.get(0));


                req.getRequestDispatcher("/WEB-INF/jsp/account/account_modi.jsp").forward(req, resp);
                break;
            case "/netctoss/sure/update.acc":
                String id3 = req.getParameter("id");
                String realName1 = req.getParameter("rname");
                String newPasswd = req.getParameter("newPasswd");
                String telno = req.getParameter("telno");
                String em = req.getParameter("em");
                String occupation = req.getParameter("occupation");
                String radSex = req.getParameter("radSex");
                String adr = req.getParameter("adr");
                String zi = req.getParameter("zi");
                String tencqq = req.getParameter("tencqq");
                if (newPasswd == null || newPasswd.equals("")) {
//                    req.getRequestDispatcher("/WEB-INF/jsp/account/account_list.jsp").forward(req, resp);
                    resp.sendRedirect("http://localhost:8080/netctoss/list.acc");
                } else {
                    accountService.modiInfoById(realName1, newPasswd, telno, em, occupation, radSex, adr, zi, tencqq, id3);
                    resp.sendRedirect("http://localhost:8080/netctoss/list.acc");
                }

                break;
            case "/netctoss/add.acc":
                req.getRequestDispatcher("/WEB-INF/jsp/account/account_add.jsp").forward(req, resp);
                break;
            case "/netctoss/sure/add.acc":
                String status2 = req.getParameter("status");
                String realName2 = req.getParameter("real_name");
                String idcard_no = req.getParameter("idcard_no");
                String login_name = req.getParameter("login_name");
                String login_passwd = req.getParameter("login_passwd");
                String teleplone = req.getParameter("telephone");
                String birthdate = req.getParameter("birthdate");
                String email = req.getParameter("email");
                String occupation1 = req.getParameter("occupation");
                String gender = req.getParameter("radSex");
                String mailaddress = req.getParameter("mailaddress");
                String zipcode = req.getParameter("zipcode");
                String qq = req.getParameter("qq");

                accountService.insertAccount(status2, realName2, idcard_no, login_name, login_passwd,
                        teleplone, birthdate, email, occupation1, gender, mailaddress, zipcode, qq);
                resp.sendRedirect("http://localhost:8080/netctoss/list.acc");

                break;
            case "/netctoss/ajax/list.acc":
                String pageNoGet1 = req.getParameter("apageNo");
                String realName3 = req.getParameter("arealName");
                String idcardNo1 = req.getParameter("aidcardNo");
                String loginName1 = req.getParameter("aloginName");
                String status3 = req.getParameter("astatus");



                Account account1 = new Account(realName3, idcardNo1, loginName1, status3);


                int endPage1 = accountService.getAccountEndPage();
                int likeEndPage1 = accountService.getLikeAccountEndPage(account1);

                int pageNo1 = 1;

                if (pageNoGet1 != null && !"".equals(pageNoGet1)) {

                    pageNo1 = Integer.parseInt(pageNoGet1);

                }

                List<Account> accounts2 = accountService.getAccountByPage(Const.PAGE_SIZE, pageNo1, account1);



                req.setAttribute("current", pageNo1);
                JSONObject jsonObjectCheck = new JSONObject();
                if (idcardNo1 != null || realName3 != null || loginName1 != null) {
                    req.setAttribute("endPage", likeEndPage1);
                    jsonObjectCheck.put("lastPage", likeEndPage1);
                } else {
                    req.setAttribute("endPage", endPage1);
                    jsonObjectCheck.put("lastPage", endPage1);
                }


                JSONArray jsonArray = new JSONArray();
                for (Account account2 : accounts2) {
                    Integer jid = account2.getId();
                    String jrealName = account2.getRealName();
                    String jidcardNo = account2.getIdcardNo();
                    String jloginName = account2.getLoginName();
                    String jstatus = account2.getStatus();
                    Date date = account2.getCreateDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String createTime = sdf.format(date);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", jid);
                    jsonObject.put("realName", jrealName);
                    jsonObject.put("idcardNo", jidcardNo);
                    jsonObject.put("loginName", jloginName);
                    jsonObject.put("status", jstatus);
                    jsonObject.put("createTime", createTime);
                    jsonArray.add(jsonObject);
                }

                jsonObjectCheck.put("thisPage", pageNoGet1);
                jsonArray.add(jsonObjectCheck);
                resp.getWriter().write(jsonArray.toString());
                break;

        }

    }

}
