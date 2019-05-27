package com.itek.servlet.day04.dao.inter;


import com.itek.servlet.day04.module.Account;

import java.util.List;

/**
 * @Param
 * @description Account表的接口，定义了如下方法
 * @date 2019/5/24 18:50
 * @return
 */

public interface AccountInter {

    /**
     * @Param
     * @description 数据库增加数据功能
     * @date 2019/5/24 18:51
     * @return
     */

    int addAccount(Account account);

    /**
     * @Param
     * @description 数据库删除字段功能
     * @date 2019/5/24 18:51
     * @return
     */

    int deleteAccountById(int id);

    /**
     * @Param
     * @description 数据库查询功能
     * @date 2019/5/24 18:51
     * @return
     */

    List<Account> selectAccount();

    /**
     * @Param
     * @description 数据库更改数据功能
     * @date 2019/5/24 18:52
     * @return
     */

    int updateAccountById(Account account, int id);

}
