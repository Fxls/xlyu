/**
 * @Author xlyu
 * @Date 2019/5/1
 * @Description
 */
package chatRoom.gui;


import day01.DBUtil;
import day01.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-05-01 10:50
 **/
public class LoginFrame3 extends JFrame {

    private JLabel mainPanel;
    private JTextField pnField;
    private JTextField pwdField;
    private JLabel pnTips;
    private JLabel pwdTips;
    private JLabel logTips;
    private JButton regBtn;
    private JButton loginBtn;

    public static String getNickname() {
        return nickname;
    }

    private static String nickname;


    public LoginFrame3() {
        setTitle("欢迎登录");

        pnField = new JTextField();
        pnField.setFont(new Font("黑体", Font.BOLD, 20));
        pnField.setBounds(165, 236, 243, 37);

        pwdField = new JTextField();
        pwdField.setFont(new Font("黑体", Font.BOLD, 20));
        pwdField.setBounds(165, 273, 243, 37);

        loginBtn = new JButton("登录");
        loginBtn.setBounds(270, 350, 100, 50);

        regBtn = new JButton("注册");
        regBtn.setBounds(170, 350, 100, 50);

        pnTips = new JLabel();
        pnTips.setForeground(Color.red);
        pnTips.setBounds(408, 236, 40, 37);

        pwdTips = new JLabel();
        pwdTips.setForeground(Color.red);
        pwdTips.setBounds(408, 273, 40, 37);

        logTips = new JLabel();
        logTips.setForeground(Color.red);
        logTips.setBounds(220, 300, 243, 37);

        ImageIcon backPicture = new ImageIcon("E:\\soft\\git\\xlyu\\jdbc\\src\\chatRoom\\gui\\back.png");
        mainPanel = new JLabel();
        mainPanel.setIcon(backPicture);

        mainPanel.add(pnField);
        mainPanel.add(pwdField);
        mainPanel.add(regBtn);
        mainPanel.add(loginBtn);
        mainPanel.add(pnTips);
        mainPanel.add(pwdTips);
        mainPanel.add(logTips);
        this.add(mainPanel);

        // 初始化窗体
        this.setSize(545, 450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //注册按钮响应
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterFrame();
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、采集登录数据
                String pn = pnField.getText();
                String pwd = pwdField.getText();

                User user = new User(pn, pwd, null);

                //2、 TODO 合法性校验
                String pnRegex = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
                String pwdRegex = "\\d{6}";

                pnTips.setText("");
                if (!pn.matches(pnRegex)) {
                    pnTips.setText("×");
                    return;
                }

                pwdTips.setText("");
                if (!pwd.matches(pwdRegex)) {
                    pwdTips.setText("×");
                    return;
                }

                //3、TODO 对登录用户的手机号和密码进行核对
                if (checkUser(user)) {
                    nickname = GetNickname(user);
                    dispose();
                    new Client();
                } else {
                    logTips.setText("");
                    logTips.setText("用户名或密码错误");
                    return;
                }


            }
        });
    }

    private String GetNickname(User user) {
        Connection conn = DBUtil.getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "select nickname from administration_info where phonenum = '" +
                    user.getPhoneNUmber() + "' and pwd = '" +
                    user.getPwd() + "'";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                nickname = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return nickname;
    }

    private boolean checkUser(User user) {
        Connection conn = DBUtil.getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "select count(1) from administration_info where phonenum = '" +
                    user.getPhoneNUmber() + "' and pwd = '" +
                    user.getPwd() + "'";
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            int count = rs.getInt(1);
            if (count >= 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }

        return false;
    }


    public static void main(String[] args) {
        new LoginFrame3();
    }
}
