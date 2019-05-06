/**
 * @Author xlyu
 * @Date 2019/5/5
 * @Description
 */
package day03;

import day01.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: jdbc
 * @description: 批量处理
 * @author: xlyu
 * @create: 2019-05-05 15:37
 **/
public class BatchTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        String sql = "insert into card_info values (null,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 1000; i++) {
            ps.setString(1,"xlyu"+i);
            ps.setInt(2, (int) (Math.random() * 1000));
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        conn.close();
    }
}
