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
 * @description: 返回主键
 * @author: xlyu
 * @create: 2019-05-05 15:51
 **/
public class ReturnPrimaryKeyValue {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("insert into dept (dname) values ('Administration Department')", new String[]{"deptno"});
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        System.out.println(rs.getInt(1));
        int deptno = rs.getInt(1);

        PreparedStatement ps2 = conn.prepareStatement("insert into emp(ename,sal,deptno) values ('xlyu',123456,?)");
        ps2.setInt(1, deptno);
        ps2.executeUpdate();
        conn.commit();
        ps.close();
        ps2.close();
        rs.close();
        conn.close();
    }
}
