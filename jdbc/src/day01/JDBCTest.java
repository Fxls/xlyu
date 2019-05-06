/**
 * @Author xlyu
 * @Date 2019/4/30
 * @Description
 */
package day01;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-04-30 08:59
 **/
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、创建连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xlyu_test?useUnicode=true&characterEncoding=utf-8",
                "root",
                "root"
        );

        //3、语句对象
        Statement stat = conn.createStatement();
        /** 4、执行插入语句
         String sqlInsert = "insert into x_test1 values(null,'18855052340','123456')";
         int count = stat.executeUpdate(sqlInsert);
         if (count != 1) {
         System.out.println("插入数据失败");
         }
         */
        /**4、修改语句
         String sqlUpdate = "update x_test1 set phonenumber='18855052342'where id = 2";
         int count = stat.executeUpdate(sqlUpdate);
         if (count < 1) {
         System.out.println("修改失败");
         }*/
        //4、删除语句
        /**String sqlDelete = "delete from x_test1 where id = 1";
         int count = stat.executeUpdate(sqlDelete);
         if (count < 1) {
         System.out.println("删除失败");
         }*/
        //5、查询语句
        String sqlSel = "select id,phonenumber,pwd from x_test1";
        ResultSet rs = stat.executeQuery(sqlSel);
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setPhoneNUmber(rs.getString(2));
            user.setPwd(rs.getString(3));
            list.add(user);
        }
        System.out.println(list);
        conn.close();
    }
}
