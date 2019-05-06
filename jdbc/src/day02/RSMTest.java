/**
 * @Author xlyu
 * @Date 2019/5/5
 * @Description
 */
package day02;

import day01.DBUtil;

import java.sql.*;

/**
 * @program: jdbc
 * @description: 结果集
 * @author: xlyu
 * @create: 2019-05-05 14:51
 **/
public class RSMTest {
    public static void main(String[] args) throws SQLException {
        /**
         *
         */
        Connection conn = DBUtil.getPoolConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from userlist";
        ResultSet rs = stat.executeQuery(sql);
        ResultSetMetaData rsm = rs.getMetaData();
        //字段数
        int count = rsm.getColumnCount();
        System.out.println(count);
        //遍历字段
        for (int i = 1; i <= count; i++) {
            //字段名
            System.out.println(rsm.getColumnName(i));
        }
        rs.close();
        stat.close();
        conn.close();
    }
}
