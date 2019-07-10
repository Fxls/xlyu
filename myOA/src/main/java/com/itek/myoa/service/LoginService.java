package com.itek.myoa.service;

import com.itek.myoa.domain.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface LoginService {
    /**
     * 检测该用户是否存在
     * @param user
     * @return
     */
    List<User> checkUser(User user);
}
