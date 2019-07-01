/**
 * @Author xlyu
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.dao;

import com.itek.spring.day05.domain.User;
import com.itek.spring.day05.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: springDay04
 * @description:
 * @author: xlYu
 * @create: 2019-06-29 15:37
 **/
@Repository("userDao")
public class UserDao {

    public User selectByUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getPoolConnection();
            String sql = "select * from admin_info where admin_code = ? and password = ?";
            ps = conn.prepareStatement(sql);


            ps.setString(1, user.getAdminCode());
            ps.setString(2, user.getPassword());


            rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }


}
