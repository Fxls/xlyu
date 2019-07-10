package com.itek.myoa.service;

import com.itek.myoa.domain.Menu;

import java.util.List;

/**
 * @author Administrator
 */
public interface MenuService {
    /**
     * 插入菜单
     * @param menu
     * @return
     */
    String insertMenu(Menu menu);

    /**
     * 获取父级菜单
     * @return
     */
    List<Menu>  getMenu();

    /**
     * 获取子菜单
     * @param parentId
     * @return
     */
    List<Menu> getSonMenu(String parentId);

    List<Menu> getTopMenuByLoginName(String loginName);

    List<Menu> getSonMenuByLoginNameAndParentId(String parentId, String name);
}
