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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Account> selectByPage(int pageSize, int pageNo, Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> accounts = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from account where 1=1 ");

        //TODO 模糊查询
        if (account.getIdcardNo() != null) {
            sql.append(" and idcard_no like '%" + account.getIdcardNo() + "%' ");
        }
        if (account.getRealName() != null) {
            sql.append(" and real_name like '%" + account.getRealName() + "%' ");
        }
        if (account.getLoginName() != null) {
            sql.append(" and login_name like '%" + account.getLoginName() + "%' ");
        }
        if (account.getStatus() != null && !account.getStatus().equals("-1")) {
            sql.append(" and status = " + account.getStatus());
        }

        sql.append(" limit  ?,? ");
        try {
            int start = (pageNo - 1) * pageSize;
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql.toString());
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

    @Override
    public int getLikeAccountTotalCount(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder("select count(1) from account where 1=1 ");

        //TODO 模糊查询
        if (account.getIdcardNo() != null) {
            sql.append(" and idcard_no like '%" + account.getIdcardNo() + "%'");
        }
        if (account.getRealName() != null) {
            sql.append(" and real_name like '%" + account.getRealName() + "%'");
        }
        if (account.getLoginName() != null) {
            sql.append(" and login_name like '%" + account.getLoginName() + "%'");
        }
        if (account.getStatus() != null && !account.getStatus().equals("-1")) {
            sql.append(" and status = " + account.getStatus());
        }


        try {

            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql.toString());
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

    @Override
    public List<Account> getDetailInfo(String realNameDetail) {
//        System.out.println("**************");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();

        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from account where real_name = ? ");

            ps.setString(1, realNameDetail);
            rs = ps.executeQuery();

            rs.next();

            list.add(new Account(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6),
                    rs.getDate(7),
                    rs.getDate(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getDate(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getDate(19),
                    rs.getString(20)
            ));
//            System.out.println(list.get(0).getStatus() + "11111111");

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(conn);
        return null;
    }

    @Override
    public int updateStatusById(int id, String status1) {
        Connection conn = null;
        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("update  account set status = ? where id = ?");
            ps.setString(1, status1);
            ps.setInt(2, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return 0;
    }

    @Override
    public List<Account> selectInfoById(String id) {
//        System.out.println("**************");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();

        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from account where id = ? ");

            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();

            rs.next();

            list.add(new Account(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6),
                    rs.getDate(7),
                    rs.getDate(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getDate(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getDate(19),
                    rs.getString(20)
            ));


            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(conn);
        return null;
    }

    @Override
    public String selectPwdById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select login_passwd from account where id = ?");
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("login_passwd");

        } catch (SQLException e) {
            return null;
        } finally {
            DBUtil.closeConnection(conn);
        }
//        return null;
    }

    @Override
    public String getIdOfReById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("SELECT b.idcard_no FROM account as b WHERE b.id =(SELECT a.recommender_id FROM account AS a WHERE id = ? )");
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            return null;
        } finally {
            DBUtil.closeConnection(conn);
        }

    }

    @Override
    public int modiAccountById(String real_name, String login_passwd, String telephone, String email, String occupation, String gender, String mailaddressdr, String zipcode, String qq, String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("UPDATE account SET real_name=?, login_passwd=?, telephone=?, email=?, occupation=?, gender=?, mailaddress=?, zipcode=?, qq=? WHERE id=?");
            ps.setString(1, real_name);
            ps.setString(2, login_passwd);
            ps.setString(3, telephone);
            ps.setString(4, email);
            ps.setString(5, occupation);
            ps.setString(6, gender);
            ps.setString(7, mailaddressdr);
            ps.setString(8, zipcode);
            ps.setString(9, qq);
            ps.setInt(10, Integer.parseInt(id));
            int count = ps.executeUpdate();
            if (count > 0) {
                return count;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
        }
    }

    @Override
    public int selectRealName(String realName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select real_name from account where real_name=?");
            ps.setString(1, realName);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    count++;
                }
            }
            return count;
        } catch (SQLException e) {
            System.out.println("name wrong");
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
        }
    }

    @Override
    public int selectIdcard(String idcard) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idcount = 0;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select idcard_no from account where idcard_no= ?");
            ps.setString(1, idcard);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    idcount++;
                }
            }
            return idcount;
        } catch (SQLException e) {
            System.out.println("idcard wrong");
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
        }

    }

    @Override
    public int selectLoginname(String loginnname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int loginNameCount = 0;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select login_name from account where login_name = ?");
            ps.setString(1, loginnname);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    loginNameCount++;
                }
            }
            return loginNameCount;
        } catch (SQLException e) {
            System.out.println("loginNameCount wrong");
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
        }

    }

    @Override
    public int inserNewAccount(String status, String realName, String idcard_no, String login_name, String login_passwd, String teleplone, String birthdate, String email, String occupation, String gender, String mailaddress, String zipcode, String qq) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createDate = sdf.format(date);
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("insert into account (id,status,real_name,idcard_no,login_name,login_passwd,telephone,birthdate,email,occupation,gender,mailaddress,zipcode,qq,create_date) values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, status);
            ps.setString(2, realName);
            ps.setString(3, idcard_no);
            ps.setString(4, login_name);
            ps.setString(5, login_passwd);
            ps.setString(6, teleplone);
            ps.setString(7, birthdate);
            ps.setString(8, email);
            ps.setString(9, occupation);
            ps.setString(10, gender);
            ps.setString(11, mailaddress);
            ps.setString(12, zipcode);
            ps.setString(13, qq);
            ps.setString(14,createDate);
            int count = ps.executeUpdate();
            return count;

        } catch (SQLException e) {
            System.out.println("insert wrong");
            return 0;
        } finally {
            DBUtil.closeConnection(conn);
        }

    }
}
