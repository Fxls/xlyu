package com.itek.myoa.service;

import com.itek.myoa.domain.User;

/**
 * @author xlyu
 */
public interface UserService {

    /**
     * 新增user
     */
    String insertUser(User user);

    /**
     * 查询用户id
     * @param applyerName
     * @return
     */
    Integer getId(String applyerName);
}
