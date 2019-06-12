/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.dao.impl;

import com.iek.netctoss.dao.inter.AccountInter;
import com.iek.netctoss.module.Account;
import com.iek.netctoss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-11 10:43
 **/
public class AccountImpl implements AccountInter {
    @Override
    public List<Account> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,real_name,idcard_no,login_name,status,create_date,last_login_time  from account";
        List<Account> accounts = new ArrayList<>();
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("id"),
                        rs.getString("real_name"),
                        rs.getString("idcard_no"),
                        rs.getString("login_name"),
                        rs.getString("status"),
                        rs.getDate("create_date"),
                        rs.getDate("last_login_time")
                ));
            }
            return accounts;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Account> selectByPage(int pageSize, int pageNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> accounts = new ArrayList<>();
        try {
            int start = (pageNo - 1) * pageSize;
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select id,real_name,idcard_no,login_name,status,create_date,last_login_time  from account limit ?,?");
            ps.setInt(1, start);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("id"),
                        rs.getString("real_name"),
                        rs.getString("idcard_no"),
                        rs.getString("login_name"),
                        rs.getString("status"),
                        rs.getDate("create_date"),
                        rs.getDate("last_login_time")
                ));
            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public int getAccountTotalCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select count(1) from account");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return 0;
    }
}
