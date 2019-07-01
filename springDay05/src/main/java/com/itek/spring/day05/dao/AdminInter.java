package com.itek.spring.day05.dao;

import com.itek.spring.day05.domain.Menu;
import com.itek.spring.day05.domain.User;

import java.util.List;

/**
 * @Param
 * @description DAO接口
 * @date 2019/6/10 15:34
 * @return
 * @author xlYu
 */
public interface AdminInter {
    /**
     * 根据用户名和密码查询用户
     * @param name
     * @param pwd
     * @return
     */
    User getInfo(String name, String pwd);

    /**
     * 根据id获取权限
     * @param id
     * @return
     */
    List<Menu> getMenuById(Integer id);
}
