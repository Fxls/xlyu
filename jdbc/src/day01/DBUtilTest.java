/**
 * @Author xlyu
 * @Date 2019/4/30
 * @Description
 */
package day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-04-30 14:24
 **/
public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getPoolConnection();

        //创建语句对象
        Statement stat = conn.createStatement();

        //执行sql
        ResultSet rs = stat.executeQuery("select * from x_test1");
        /**
         * 获取数据库内容
         * rs.next() -> 判断数据库是否还有未读取完的内容
         * rs.getxxx(?) -> 获取内容
         */

        DBUtil.closeConnection(conn);
    }
}
