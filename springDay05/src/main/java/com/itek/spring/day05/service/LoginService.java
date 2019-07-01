package com.itek.spring.day05.service;

import com.itek.spring.day05.commons.CheckResult;
import com.itek.spring.day05.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xlYu
 */
public interface LoginService {

    /**
     * 用户登录校验
     * @param user
     * @param req
     * @param capInput
     * @return
     */
    CheckResult<User> checkUser(User user, HttpServletRequest req,String capInput);
}
