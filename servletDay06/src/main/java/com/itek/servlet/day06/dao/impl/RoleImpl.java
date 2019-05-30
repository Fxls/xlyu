/**
 * @Author xlyu
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servlet.day06.dao.impl;

import com.itek.servlet.day06.dao.inter.RoleInter;
import com.itek.servlet.day06.module.Role;
import com.itek.servlet.day06.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay06
 * @description:
 * @author: xlyu
 * @create: 2019-05-29 16:03
 **/
public class RoleImpl implements RoleInter {

    @Override
    public List<Role> selectRole() {

        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT r.id,r. NAME,GROUP_CONCAT(rp. NAME) FROM role AS r LEFT JOIN n_role_power AS n ON r.id = n.role_id LEFT JOIN role_power AS rp ON rp.id = n.power_id GROUP BY r.id;";
        ResultSet rs = null;
        List<Role> list = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("select方法运行错误！");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    @Override
    public int addRole(String roleName) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("insert into role values(null,?)");
            ps.setString(1, roleName);
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("role insert successful!");
            } else {
                System.out.println("role insert wrong!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("wrong!!!");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public Integer selectId(String roleName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select id from role where name = ?");
            ps.setString(1, roleName);
            rs = ps.executeQuery();
            rs.next();
            id = rs.getInt(1);
            System.out.println("获取id成功");
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取id失败！");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    @Override
    public int addN_role_power(Integer id, String[] arr) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();

            ps = conn.prepareStatement("insert into n_role_power values(?,?)");
            for (int i = 0; i < arr.length; i++) {

                ps.setInt(1, id);
                ps.setInt(2, Integer.parseInt(arr[i]));
                ps.addBatch();

            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("delete from role where id =?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("role delete successful!");
            } else {
                System.out.println("role delete wrong!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("wrong!!!");
        } finally {
            DBUtil.closeConnection(conn);
        }
        return -1;
    }


}
