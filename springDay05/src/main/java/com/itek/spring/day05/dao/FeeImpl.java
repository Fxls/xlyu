/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.dao;

import com.itek.spring.day05.domain.Fee;
import com.itek.spring.day05.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 16:34
 **/
@Repository("feeImpl")
public class FeeImpl implements FeeInter {
    @Override
    public List<Fee> selectFee() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from cost";
        List<Fee> list = new ArrayList<>();
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Fee(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getInt(6)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Fee> selectFeeOrderByCost(String sortType) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Fee> list = new ArrayList<>();
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from cost order by base_cost    "+sortType);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Fee(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getInt(6)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Fee> selectFeeOrderByTime(String sortType) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Fee> list = new ArrayList<>();
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from cost order by base_duration  "+sortType);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Fee(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getInt(6)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }
}
