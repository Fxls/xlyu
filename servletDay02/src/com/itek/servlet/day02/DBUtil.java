/**
 * @Author xlyu
 * @Date 2019/5/23
 * @Description
 */
package com.itek.servlet.day02;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: servletDay02
 * @description:
 * @author: xlyu
 * @create: 2019-05-23 19:16
 **/

public class DBUtil {
    private static Properties props = new Properties();
    private static BasicDataSource ds = new BasicDataSource();
    private static String driver;
    private static String url;
    private static String name;
    private static String pwd;

    static {
        try {
            FileInputStream fis = new FileInputStream("E:\\soft\\git\\xlyu\\servletDay02\\src\\com\\itek\\servlet\\day02\\jdbc.properties");
            props.load(fis);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            name = props.getProperty("name");
            pwd = props.getProperty("pwd");

            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(name);
            ds.setPassword(pwd);

            ds.setInitialSize(10);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
