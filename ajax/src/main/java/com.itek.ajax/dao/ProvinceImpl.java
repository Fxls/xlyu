/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.dao;

import com.itek.ajax.module.Province;
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
 * @create: 2019-06-13 19:58
 **/
public class ProvinceImpl implements ProvinceInter {
    @Override
    public List<Province> selectProvince() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Province> list = new ArrayList<>();
        try {
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement("select id,code,name from province");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Province(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
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
