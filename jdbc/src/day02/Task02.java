/**
 * @Author xlyu
 * @Date 2019/5/5
 * @Description
 */
package day02;

import day01.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-05 17:24
 **/
public class Task02 {
    public static void main(String[] args) throws Exception {
        Connection conn = DBUtil.getPoolConnection();
        Statement statement = conn.createStatement();
        String name = "a'OR'b'='b";
        String sqlStat = "select sal from emp where ename = 'clark' ";
        String sqlStat2 = "select sal from emp where ename = '" + name + "'";
//        ResultSet rs = statement.executeQuery(sqlStat);
        ResultSet rs2 = statement.executeQuery(sqlStat2);
//        while (rs.next()) {
//            System.out.println(rs.getInt(1));
//        }
        while (rs2.next()) {
            System.out.println(rs2.getInt(1));
        }
//        rs.close();
        rs2.close();
        statement.close();
        conn.close();
    }
}
