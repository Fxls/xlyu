/**
 * @Author xlyu
 * @Date 2019/5/6
 * @Description
 */
package day02;

import day01.DBUtil;
import org.dom4j.rule.RuleSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-06 08:38
 **/
public class Task02_1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();
        String sql = "select sal from emp where ename = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, "clark");
        ps.setString(1,"a'or'b'='b");
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1));
        ps.close();
        rs.close();
        conn.close();
    }
}
