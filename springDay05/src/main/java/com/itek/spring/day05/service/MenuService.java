package com.itek.spring.day05.service;

import com.itek.spring.day05.domain.Menu;

import java.util.List;

/**
 * @Param
 * @description 菜单处理
 * @date 2019/6/11 8:57
 * @return
 */

public interface MenuService {
    /**
     * 查询用户权限
     * @param id
     * @return
     */
    List<Menu> selectMenusByUserId(Integer id);
}
