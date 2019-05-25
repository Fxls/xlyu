/**
 * @Author xlyu
 * @Date 2019/5/24
 * @Description
 */
package com.itek.servlet.day03.dao.impl;

import com.itek.servlet.day03.dao.inter.AccountInter;
import com.itek.servlet.day03.module.Account;
import com.itek.servlet.day03.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay03
 * @description: 接口实现类
 * @author: xlyu
 * @create: 2019-05-24 14:30
 **/
public class AccountImpl implements AccountInter {


    /**
     * @return int
     * @Param account={}
     * @description 重写AccountInter接口中的抽象方法
     * @date 2019/5/24 18:47
     */
    @Override
    public int addAccount(Account account) {

        //jdbc操作
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //jdbc连接池
            conn = DBUtil.getPoolConnection();

            //sql操作
            ps = conn.prepareStatement("insert into account (login_name,status,real_name,idcard_no,telephone) values (?,?,?,?,?)");
            ps.setString(1, account.getLogin_name());
            ps.setString(2, account.getStatus());
            ps.setString(3, account.getReal_name());
            ps.setString(4, account.getIdcard_no());
            ps.setString(5, account.getTelephone());

            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据插入成功！！");
            } else {
                System.out.println("数据插入失败！！");
            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据插入失败！！！！！");
        } finally {
            //不要忘记关闭连接池以释放资源
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    /**
     * @return
     * @Param
     * @description 重写AccountInter接口中的抽象方法
     * @date 2019/5/24 18:48
     */
    @Override
    public int deleteAccountById(int id) {
        //jdbc操作
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //jdbc连接池
            conn = DBUtil.getPoolConnection();

            //sql操作
            ps = conn.prepareStatement("delete from account where account_id = ?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据删除成功");
            } else {
                System.out.println("数据删除失败");
            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查询失败！！！！！");
        } finally {
            //不要忘记关闭连接池以释放资源
            DBUtil.closeConnection(conn);
        }
        return -1;
    }

    /**
     * @return
     * @Param
     * @description 重写AccountInter接口中的抽象方法
     * @date 2019/5/24 18:49
     */
    @Override
    public List<Account> selectAccount() {
        //jdbc操作
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = null;
        try {
            //jdbc连接池
            conn = DBUtil.getPoolConnection();

            //sql操作
            ps = conn.prepareStatement("select * from account");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查询失败！！！！！");
        } finally {
            //不要忘记关闭连接池以释放资源
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    /**
     * @return
     * @Param
     * @description 重写AccountInter接口中的抽象方法
     * @date 2019/5/24 19:56
     */

    @Override
    public int updateAccountById(Account account,int id) {
        //jdbc操作
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //jdbc连接池
            conn = DBUtil.getPoolConnection();

            //sql操作
            ps = conn.prepareStatement("update account set login_name=?,status=?,real_name=?,idcard_no=?,telephone=? where account_id = ?");
            ps.setString(1, account.getLogin_name());
            ps.setString(2, account.getStatus());
            ps.setString(3, account.getReal_name());
            ps.setString(4, account.getIdcard_no());
            ps.setString(5, account.getTelephone());
            ps.setInt(6, id);


            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据更新成功");
            } else {
                System.out.println("数据更新失败");
            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据更新失败！！！！！");
        } finally {
            //不要忘记关闭连接池以释放资源
            DBUtil.closeConnection(conn);
        }
        return -1;

    }
}
