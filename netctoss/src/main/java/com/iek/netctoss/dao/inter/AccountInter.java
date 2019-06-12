package com.iek.netctoss.dao.inter;

import com.iek.netctoss.module.Account;

import java.util.List;

public interface AccountInter {
    List<Account> selectAll();

    List<Account> selectByPage(int pageSize, int pageNo);

    int getAccountTotalCount();
}
