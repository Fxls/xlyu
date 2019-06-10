/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.dao.inter;

import com.iek.netctoss.dao.impl.AdminInter;
import com.iek.netctoss.module.User;
import com.iek.netctoss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 15:36
 **/
public class AdminImpl implements AdminInter {
    @Override
    public User getInfo(String name, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from admin_info where admin_code=? and password = ?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String adminCode = rs.getString(2);
                String password = rs.getString(3);
                String username = rs.getString(4);
                String telephone = rs.getString(5);
                String email = rs.getString(6);
                Date enrollDate = rs.getDate(7);
                return new User(id, adminCode, password, username, telephone, email, enrollDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        //查询异常返回一个null值
        return null;
    }
}
