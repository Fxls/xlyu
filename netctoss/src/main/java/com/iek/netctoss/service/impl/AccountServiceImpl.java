/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.service.impl;

import com.iek.netctoss.commons.Const;
import com.iek.netctoss.dao.impl.AccountImpl;
import com.iek.netctoss.dao.inter.AccountInter;
import com.iek.netctoss.module.Account;
import com.iek.netctoss.service.inter.AccountService;

import java.util.List;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-11 10:27
 **/
public class AccountServiceImpl implements AccountService {
    private AccountInter accountInter = new AccountImpl();

    @Override
    public List<Account> getAccount() {
        return accountInter.selectAll();
    }

    @Override
    public List<Account> getAccountByPage(int pageSize, int pageNo, Account account) {

        return accountInter.selectByPage(pageSize, pageNo, account);
    }

    @Override
    public int getAccountEndPage() {
        int totalCount = accountInter.getAccountTotalCount();
        if (totalCount % Const.PAGE_SIZE > 0) {
            return (totalCount / Const.PAGE_SIZE) + 1;
        }
        return totalCount / Const.PAGE_SIZE ;


    }

    @Override
    public int getLikeAccountEndPage(Account account) {
        int totalCount = accountInter.getLikeAccountTotalCount(account);
        if (totalCount % Const.PAGE_SIZE > 0) {
            return (totalCount / Const.PAGE_SIZE) + 1;
        }
        return totalCount / Const.PAGE_SIZE ;
    }

    @Override
    public List<Account> getDetailInfo(String realNameDetail) {
        return accountInter.getDetailInfo(realNameDetail);
    }

    @Override
    public boolean updateStatus(int id, String status1) {
        int count = accountInter.updateStatusById(id, status1);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Account> getInfoById(String id) {
        return accountInter.selectInfoById(id);


    }

    @Override
    public String getPwd(String id) {
        return accountInter.selectPwdById(id);
    }

    @Override
    public String getReIdNo(String id) {
        return accountInter.getIdOfReById(id);
    }

    @Override
    public int modiInfoById(String real_name, String login_passwd, String telephone, String email, String occupation, String gender, String mailaddressdr, String zipcode, String qq, String id) {
        return accountInter.modiAccountById(real_name, login_passwd, telephone, email, occupation, gender, mailaddressdr, zipcode, qq, id);
    }

    @Override
    public boolean selectRealName(String name) {
        int count = accountInter.selectRealName(name);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean selectIdcard(String idcard) {
        int count = accountInter.selectIdcard(idcard);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean selectLoginname(String loginnname) {
        int count = accountInter.selectLoginname(loginnname);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertAccount(String status,
                             String realName,
                             String idcard_no,
                             String login_name,
                             String login_passwd,
                             String teleplone,
                             String birthdate,
                             String email,
                             String occupation,
                             String gender,
                             String mailaddress,
                             String zipcode,
                             String qq) {
        return accountInter.inserNewAccount(status,
                realName,
                idcard_no,
                login_name,
                login_passwd,
                teleplone,
                birthdate,
                email,
                occupation,
                gender,
                mailaddress,
                zipcode,
                qq);
    }


}
