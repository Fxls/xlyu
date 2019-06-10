package com.iek.netctoss.service;

import com.iek.netctoss.commons.ServiceResult;
import com.iek.netctoss.module.User;

/**
 * @Param
 * @description 业务处理接口
 * @date 2019/6/10 15:31
 * @return
 */


public interface LoginService {
    ServiceResult<User> result(String name, String pwd, String cap);
}
