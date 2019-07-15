/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.RoleMapper;
import com.itek.myoa.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 16:47
 **/

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String insertRole(Role role) {
        int count = roleMapper.insert(role);
        if (count > 0) {
            return "角色插入成功";
        }
        return "角色插入失败";
    }

    @Override
    public int getRoleIdByTables(Integer applicationId) {
        Set<Integer> set = roleMapper.seleceRoleId(applicationId);
        List<Integer> list = new ArrayList<>(set);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.get(0);
    }

    @Override
    public int getRoleIdByUserName(String name) {
        int roleId = roleMapper.getRoleId(name);


        return roleId;
    }
}
