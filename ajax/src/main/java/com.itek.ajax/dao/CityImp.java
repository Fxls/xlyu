/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.dao;

import com.itek.ajax.module.City;
import com.itek.ajax.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 22:03
 **/
public class CityImp implements CityInter {
    @Override
    public List<City> selectAllCityByProvince(String provincecode) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<City> list = new ArrayList<>();

        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select * from city where provincecode = ?");
            ps.setString(1, provincecode);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new City(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
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
