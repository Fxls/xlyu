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
 * @description: 事务自动提交测试
 * @author: xlyu
 * @create: 2019-05-05 15:13
 **/
public class AutoCommitTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();

        //数据库默认自动提交事务
//        String sql = "update  card_info set money = money-1000 where name = 'xlyu'";
//        String sql2 = "update  card_info set money = money+1000 where name = 'xlyu2'";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        PreparedStatement ps2 = conn.prepareStatement(sql2);
//        ps.executeUpdate();
//        ps2.executeUpdate();


        //人为干扰
//        String sql = "update  card_info set money = money-1000 where name = 'xlyu'";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.executeUpdate();
//
//        boolean check = true;
//        if (check) {
//            throw new SQLException("这里产生异常");
//        }
//        //这行之后的代码都不会执行了，数据库的数据也会搁置
//        String sql2 = "update  card_info set money = money+1000 where name = 'xlyu2'";
//        PreparedStatement ps2 = conn.prepareStatement(sql2);
//        ps2.executeUpdate();


        //事务自动提交改为手动提交
        conn.setAutoCommit(false);
        String sql = "update  card_info set money = money-1000 where name = 'xlyu'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        String sql2 = "update  card_info set money = money+1000 where name = 'xlyu2'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.executeUpdate();
        conn.commit();
        conn.close();
    }
}
