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
 * @description: PreparedStatement测试
 * @author: xlyu
 * @create: 2019-05-05 13:50
 **/
public class PSTest {
    public static void main(String[] args) throws SQLException {
        /**
         * PreparedStatement接口是继承自Statement接口。区别在于PreparedStatement
         * 表示预编译得SQL语句的对象，也就是说SQL语句被预编译并存储在PreparedStatement
         * 对象中，然后可以使用此对象多次高效地执行改语句。
         *
         * ? 为占位符
         */
        Connection conn = DBUtil.getPoolConnection();
        String sql = "select tel from userlist where rent = ? and acc= ?";


        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, 19);
        ps.setString(2, "AAAA");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }


        ps.close();
        conn.close();


    }
}
