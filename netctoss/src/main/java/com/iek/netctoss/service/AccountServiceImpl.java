/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.service;

import com.iek.netctoss.dao.impl.AccountImpl;
import com.iek.netctoss.dao.inter.AccountInter;
import com.iek.netctoss.module.Account;

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
}
