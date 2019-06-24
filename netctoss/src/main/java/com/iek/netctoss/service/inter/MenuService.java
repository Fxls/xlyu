package com.iek.netctoss.service.inter;

import com.iek.netctoss.module.Menu;

import java.util.List;

/**
 * @Param
 * @description 菜单处理
 * @date 2019/6/11 8:57
 * @return
 */

public interface MenuService {
    List<Menu> selectMenusByUserId(Integer id);
}
