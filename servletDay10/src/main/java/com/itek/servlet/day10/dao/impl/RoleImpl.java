/**
 * @Author xlyu
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servlet.day10.dao.impl;

import com.itek.servlet.day10.dao.inter.RoleInter;
import com.itek.servlet.day10.module.Role;
import com.itek.servlet.day10.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay10
 * @description:
 * @author: xlyu
 * @create: 2019-06-04 16:23
 **/
public class RoleImpl implements RoleInter {
    @Override
    public List<Role> selectRole() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Role> list = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("SELECT r.id,r. NAME,GROUP_CONCAT(rp. NAME) FROM role AS r LEFT JOIN n_role_power AS n ON r.id = n.role_id LEFT JOIN role_power AS rp ON rp.id = n.power_id GROUP BY r.id;");
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
}
