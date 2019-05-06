/**
 * @Author xlyu
 * @Date 2019/5/6
 * @Description
 */
package day03;

import day01.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-06 10:02
 **/
public class Task04 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        String sql = "select * from dept_day02 order by dname desc limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int pageNo = 1;
        int pageSize = 10;
        int start = (pageNo - 1) * pageSize;
        ps.setInt(1, start);
        ps.setInt(2, pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("dname"));
        }
        ps.close();
        rs.close();
        conn.close();
    }
}
