/**
 * @Author xlyu
 * @Date 2019/5/5
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
 * @description: 分页查询
 * @author: xlyu
 * @create: 2019-05-05 16:38
 **/
public class PageTest {
    public static void main(String[] args) throws SQLException {
        /**
         * 分页公式
         * int begin = (page - 1) * pageSize + 1;
         * int end = begin + pageSize -1;
         */
        Connection conn = DBUtil.getPoolConnection();
        String sql = "select * from card_info order by card desc limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int pageNo = 1;
        int pageSize = 5;
        int start = (pageNo - 1) * pageSize;
        ps.setInt(1, start);
        ps.setInt(2, pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("card"));
        }
        ps.close();
        rs.close();
        conn.close();


    }
}
