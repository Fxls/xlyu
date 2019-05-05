/**
 * @Author xlyu
 * @Date 2019/4/30
 * @Description
 */
package day01;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-04-30 14:25
 **/
public class DBUtil {
    //存储配置信息
    private static Properties props = new Properties();
    //数据库连接池对象
    private static BasicDataSource ds = new BasicDataSource();
    private static String driver;
    private static String url;
    private static String name;
    private static String pwd;

    static {
        try {
            FileInputStream fis = new FileInputStream("E:\\soft\\git\\xlyu\\jdbc\\src\\day01\\jdbc.properties");
            props.load(fis);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            name = props.getProperty("name");
            pwd = props.getProperty("pwd");

            //设置连接池对象的初始化参数
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(name);
            ds.setPassword(pwd);

            //设置其他的数据库连接池连接信息
            ds.setInitialSize(10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取连接对象
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, name, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过连接池获取数据库连接对象
     */
    public static Connection getPoolConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("close wrong");
            }
        }
    }
}
