package com.itek.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "JdbcServlet", urlPatterns = "/jdbc")
public class JdbcServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sal = req.getParameter("sal");
        Connection conn = DBUtil.getPoolConnection();
        String sql = "insert into emp (name,age,sal) values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(age));
            ps.setDouble(3, Double.parseDouble(sal));
            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据更新成功");
                PrintWriter pw = resp.getWriter();
                pw.println(name + "信息更新成功！");
            } else {
                System.out.println("数据更新失败");
                PrintWriter pw = resp.getWriter();
                pw.println(name + "信息更新失败");
            }

            ps.close();

            DBUtil.closeConnection(conn);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
