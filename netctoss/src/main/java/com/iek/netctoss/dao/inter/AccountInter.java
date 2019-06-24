package com.iek.netctoss.dao.inter;

import com.iek.netctoss.module.Account;

import java.util.List;

public interface AccountInter {
    List<Account> selectAll();

    List<Account> selectByPage(int pageSize, int pageNo,Account account);

    int getAccountTotalCount();

    int getLikeAccountTotalCount(Account account);

    List<Account> getDetailInfo(String realNameDetail);

    int updateStatusById(int id, String status1);


    List<Account> selectInfoById(String id);


    String selectPwdById(String id);

    String getIdOfReById(String id);


    int modiAccountById(String real_name, String login_passwd, String telephone, String email, String occupation, String gender, String mailaddressdr, String zipcode, String qq, String id);

    int selectRealName(String realName);

    int selectIdcard(String idcard);

    int selectLoginname(String loginnname);

    int inserNewAccount(String status, String realName, String idcard_no, String login_name, String login_passwd, String teleplone, String birthdate, String email, String occupation, String gender, String mailaddress, String zipcode, String qq);
}
