package com.iek.netctoss.dao.impl;

import com.iek.netctoss.module.User;

/**
 * @Param
 * @description DAO接口
 * @date 2019/6/10 15:34
 * @return
 */
public interface AdminInter {
    User getInfo(String name, String pwd);
}
