/**
 * @Author xlyu
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servlet.day06.service.impl;

import com.itek.servlet.day06.dao.impl.RoleImpl;
import com.itek.servlet.day06.dao.inter.RoleInter;
import com.itek.servlet.day06.module.Role;
import com.itek.servlet.day06.service.inter.RoleService;

import java.util.List;

/**
 * @program: servletDay06
 * @description:
 * @author: xlyu
 * @create: 2019-05-29 16:17
 **/
public class RoleServiceImpl implements RoleService {
    private RoleInter role = new RoleImpl();


    @Override
    public List<Role> getRoleInfo() {
        return role.selectRole();
    }


}
