/**
 * @Author xlyu
 * @Date 2019/5/5
 * @Description
 */
package day02;

import day01.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-05 17:14
 **/
public class Task01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        Statement stat = conn.createStatement();
        String sql1 = "insert into Dept_day02 values (50,'developer','beijing')";
        stat.executeUpdate(sql1);
        String sql2 = "update Dept_day02 set loc = 'ShangHai' where deptno = 50";
        stat.executeUpdate(sql2);
        stat.close();
        conn.close();
    }
}
