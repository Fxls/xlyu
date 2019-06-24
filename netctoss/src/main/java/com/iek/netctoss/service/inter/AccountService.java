package com.iek.netctoss.service.inter;

import com.iek.netctoss.module.Account;

import java.util.List;

/**
 * @Param
 * @description 账务账号处理借口
 * @date 2019/6/11 10:27
 * @return
 */

public interface AccountService {
    /**
     * @Param
     * @description 查询account信息
     * @date 2019/6/11 10:41
     * @return
     */

    List<Account> getAccount();

    List<Account> getAccountByPage(int pageSize, int pageNo,Account account);

    int getAccountEndPage();

    int getLikeAccountEndPage(Account account);

    List<Account> getDetailInfo(String realNameDetail);

    boolean updateStatus(int id, String status1);


    List<Account> getInfoById(String id);


    String getPwd(String id);

    String getReIdNo(String id);


    int modiInfoById(String real_name, String login_passwd, String telephone, String email, String occupation, String gender, String mailaddressdr, String zipcode, String qq, String id);

    boolean selectRealName(String name);

    boolean selectIdcard(String idcard);

    boolean selectLoginname(String loginnname);

    int insertAccount(String status, String realName, String idcard_no, String login_name, String login_passwd, String teleplone, String birthdate, String email, String occupation, String gender, String mailaddress, String zipcode, String qq);
}
