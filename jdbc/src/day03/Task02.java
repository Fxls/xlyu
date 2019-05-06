/**
 * @Author xlyu
 * @Date 2019/5/6
 * @Description
 */
package day03;

import day01.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-06 09:24
 **/
public class Task02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        PreparedStatement ps = conn.prepareStatement("insert into dept_day02 values (null,?,'ShangHai' )");
        for (int i = 1; i <= 100; i++) {
            ps.setString(1, "name" + i);
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        conn.close();
    }
}
