package com.iek.netctoss.service.inter;

import com.iek.netctoss.commons.ServiceResult;
import com.iek.netctoss.module.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Param
 * @description 业务处理接口
 * @date 2019/6/10 15:31
 * @return
 */


public interface LoginService {
    ServiceResult<User> result(HttpServletRequest req, String name, String pwd, String cap);
}
