/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.service.impl;

import com.iek.netctoss.dao.impl.AdminImpl;
import com.iek.netctoss.dao.inter.AdminInter;
import com.iek.netctoss.module.Menu;
import com.iek.netctoss.service.inter.MenuService;

import java.util.List;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-11 08:57
 **/
public class MenuServiceImpl implements MenuService {
    private AdminInter adminInter = new AdminImpl();

    @Override
    public List<Menu> selectMenusByUserId(Integer id) {
        return adminInter.getMenuById(id);
    }
}
