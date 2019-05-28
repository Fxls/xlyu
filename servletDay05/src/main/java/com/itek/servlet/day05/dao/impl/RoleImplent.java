/**
 * @Author xlyu
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servlet.day05.dao.impl;

import com.itek.servlet.day05.dao.interFace.RoleInterface;
import com.itek.servlet.day05.module.Role;
import com.itek.servlet.day05.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay05
 * @description: 接口实现类
 * @author: xlyu
 * @create: 2019-05-28 16:39
 **/
public class RoleImplent implements RoleInterface {

    @Override
    public List<Role> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Role> list = null;

        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from role_info");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查询失败 42");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    @Override
    public int addRole(Role role) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("insert into role_info values (null,?,?)");
            ps.setString(1, role.getName());
            ps.setString(2, role.getPriviege());
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入数据失败");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public int deleteRole(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("delete from role_info where id = ?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据删除成功！");
            } else {
                System.out.println("数据删除失败！");
            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public int updateRole(Role role, int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("update role_info set name =?,priviege=? where id = ?");
            ps.setString(1, role.getName());
            ps.setString(2, role.getPriviege());
            ps.setInt(3, id);
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据修改成功！");
            } else {
                System.out.println("数据修改失败！");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据修改失败--");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }
}
