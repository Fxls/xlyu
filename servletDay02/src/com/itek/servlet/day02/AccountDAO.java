/**
 * @Author xlyu
 * @Date 2019/5/23
 * @Description
 */
package com.itek.servlet.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay02
 * @description:
 * @author: xlyu
 * @create: 2019-05-23 23:22
 **/
public class AccountDAO {
    public List<Account> readFirstAccount() {
        List<Account> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getPoolConnection();
        String sql = "select * from account";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("account_id");
                String real_name = rs.getString("real_name");
                String login_name = rs.getString("login_name");
                String idcard_no = rs.getString("idcard_no");
                String telephone = rs.getString("telephone");
                Account account = new Account(account_id, real_name, login_name, idcard_no, telephone);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs!=null){
                    rs.close();
                }
                if (ps!=null){
                    ps.close();
                }
                if (conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
