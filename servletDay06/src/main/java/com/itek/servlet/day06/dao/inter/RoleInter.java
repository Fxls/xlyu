package com.itek.servlet.day06.dao.inter;

import com.itek.servlet.day06.module.Role;

import java.util.List;

public interface RoleInter {

    /**
     * @return
     * @Param
     * @description 查询方法
     * @date 2019/5/29 15:55
     */

    List<Role> selectRole();

    /**
     * @return
     * @Param
     * @description role表添加
     * @date 2019/5/29 19:17
     */

    int addRole(String roleName);

    Integer selectId(String roleName);
    int addN_role_power(Integer id,String [] arr);//role_id,power_id数组

    int deleteById(Integer id);

}
