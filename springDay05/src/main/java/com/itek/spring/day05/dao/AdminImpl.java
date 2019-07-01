/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.itek.spring.day05.dao;

import com.itek.spring.day05.domain.Menu;
import com.itek.spring.day05.domain.User;
import com.itek.spring.day05.util.DBUtil;
import org.springframework.stereotype.Repository;

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
 * @create: 2019-06-10 15:36
 **/
@Repository("adminDao")
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
                return new User(id, adminCode, password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        //查询异常返回一个null值
        return null;
    }

    /**
     * @return
     * @Param
     * @description 查询主页菜单权限
     * @date 2019/6/11 18:54
     */

    @Override
    public List<Menu> getMenuById(Integer id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Menu> menus = new ArrayList<>();
        try {
            String sql = "SELECT " +
                    " m.* " +
                    "FROM " +
                    " admin_info ai " +
                    "LEFT JOIN admin_role ar ON ai.id = ar.admin_id " +
                    "LEFT JOIN role_menu rm ON ar.role_id = rm.role_id " +
                    "LEFT JOIN menu m ON m.id = rm.menu_id " +
                    "WHERE " +
                    " ai.id = ?;";
            conn = DBUtil.getPoolConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                menus.add(new Menu(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return menus;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }
}
