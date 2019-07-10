package com.itek.myoa.service;

import com.itek.myoa.domain.Role;

/**
 * @author xlyu
 */
public interface RoleService {
    /**
     * 插入角色
     * @param role
     * @return
     */
     String insertRole(Role role) ;

    /**
     * 链表查询获取审批用户的角色id
     * @param applicationId
     * @return
     */
    int getRoleIdByTables(Integer applicationId);
}
