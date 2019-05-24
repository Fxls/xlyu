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

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String real_name = req.getParameter("real_name");
        String idcard_no = req.getParameter("idcard_no");
        String login_name = req.getParameter("login_name");
        String telephone = req.getParameter("telephone");

        Connection conn = DBUtil.getPoolConnection();
        String sql = "insert into account values (null ,?,1,?,?,?)";


        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,login_name);
            ps.setString(2,real_name);
            ps.setString(3,idcard_no);
            ps.setString(4,telephone);

            int count = ps.executeUpdate();
            if (count >= 1) {
                System.out.println("数据更新成功");
            } else {
                System.out.println("数据更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
