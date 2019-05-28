package com.itek.servlet.day05.dao.interFace;

import com.itek.servlet.day05.module.Role;

import java.util.List;

public interface RoleInterface {

    /**
     * @return
     * @Param
     * @description 查询数据库的方法
     * @date 2019/5/28 16:39
     */

    List<Role> selectAll();

    /**
     * @return
     * @Param
     * @description 数据库插入数据的办法
     * @date 2019/5/28 17:15
     */

    int addRole(Role role);

    /**
     * @return
     * @Param
     * @description 数据库删除记录
     * @date 2019/5/28 18:34
     */

    int deleteRole(int id);

    /**
     * @return
     * @Param
     * @description 数据库修改记录
     * @date 2019/5/28 18:43
     */

    int updateRole(Role role, int id);
}
