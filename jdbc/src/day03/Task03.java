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
 * @create: 2019-05-06 09:37
 **/
public class Task03 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        PreparedStatement ps = conn.prepareStatement(
                "insert into emp_2 values (1,'tom','manager',7839,'2014/5/1',5000,300,30)",
                new String[]{"empno"});
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

        int mgr = rs.getInt(1);


        PreparedStatement ps2 = conn.prepareStatement("insert into emp_2 values (null,'marry','clerk',?,'2014/5/28',3000,null,30)");
        PreparedStatement ps3 = conn.prepareStatement("insert into emp_2 values (null,'terry','salesman',?,'2014/5/29',2500,200,30)");
        PreparedStatement ps4 = conn.prepareStatement("insert into emp_2 values (null,'jim','salesman',?,'2014/5/26',2500,200,30)");
        ps2.setInt(1, mgr);
        ps3.setInt(1, mgr);
        ps4.setInt(1, mgr);
        ps2.executeUpdate();
        ps3.executeUpdate();
        ps4.executeUpdate();
        rs.close();
        ps.close();
        ps2.close();
        ps3.close();
        ps4.close();
        conn.close();
    }
}
