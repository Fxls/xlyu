package com.iek.netctoss.service;

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
}
