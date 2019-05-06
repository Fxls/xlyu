/**
 * @Author xlyu
 * @Date 2019/5/6
 * @Description
 */
package day03;

import java.sql.*;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-06 08:50
 **/
public class Task01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.0.226:1522:itek",
                "java12",
                "itek"
        );


        conn.setAutoCommit(false);
        String sql = "Update emp_xlyu set sal = sal*1.2 where job = 'analyst' and deptno = 20";
        String sql2 = "update emp_xlyu set sal = sal*1.3 where job = 'manager' and deptno = 20";
        PreparedStatement ps = conn.prepareStatement(sql);
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps.executeUpdate();
        ps2.executeUpdate();
        conn.commit();
        ps.close();
        ps2.close();
        conn.close();

    }
}
