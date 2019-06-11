package com.iek.netctoss.dao.inter;

import com.iek.netctoss.module.Menu;
import com.iek.netctoss.module.User;

import java.util.List;

/**
 * @Param
 * @description DAO接口
 * @date 2019/6/10 15:34
 * @return
 */
public interface AdminInter {
    User getInfo(String name, String pwd);


    /**
     * @Param
     * @description 根据用户id查询关联菜单
     * @date 2019/6/11 18:43
     * @return
     */

    List<Menu> getMenuById(Integer id);
}
