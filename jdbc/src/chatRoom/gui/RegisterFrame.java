/**
 * @Author xlyu
 * @Date 2019/4/30
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
 * @description: 注册窗体
 * @author: xlyu
 * @create: 2019-04-30 16:15
 **/
public class RegisterFrame extends JFrame {
    /**
     * 面板组件
     */
    private JLabel pnText;
    private JLabel pwdText;
    private JLabel pwdAgainText;
    private JLabel nnText;
    private JLabel pnTips;
    private JLabel pwdTips;
    private JLabel pwdAgainTips;
    private JLabel nnTips;
    private JLabel mainPanle;

    private JTextField pnField;
    private JTextField pwdField;
    private JTextField pwdAgainField;
    private JTextField nnField;

    private JButton regBtn;
    private JButton backBtn;

    /**
     * @return
     * @Param
     * @description 构造器
     * @date 2019/4/30 16:49
     */
    public RegisterFrame() {
        //初始化窗体组件
        initComponents();
        //初始化窗体
        initFrame();
        //按钮
        addBtnAction();
    }

    /**
     * @return
     * @Param
     * @description 按钮响应
     * @date 2019/4/30 16:49
     */
    private void addBtnAction() {
        //添加返回按钮
        addBackBtnAction();
        //添加注册按钮
        addRegBtnAction();
    }

    /**
     * @return
     * @Param
     * @description 注册键
     * @date 2019/4/30 16:52
     */
    private void addRegBtnAction() {
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、  采集注册信息
                String pn = pnField.getText();
                String pwd = pwdField.getText();
                String pwdAgain = pwdAgainField.getText();
                String nn = nnField.getText();
                User regUser = new User(pn, pwd, nn);
                //2、 TODO 合法性校验
                String pnRegex = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";//手机号正则校验
                String pwdRegex = "\\d{6}";//六位数字密码
                String nnRegex = "\\w{4,8}";//四到八位单词字符

                pnTips.setText("");
                if (!pn.matches(pnRegex)) {
                    pnTips.setText("手机号格式不正确");
                    return;
                    //3、 TODO 手机号是否重复
                } else if (!checkPnRepeat(pn)) {
                    pnTips.setText("手机号已注册");
                    return;
                } else {
                    pnTips.setForeground(Color.green);
                    pnTips.setText("✔");
                }

                pwdTips.setText("");
                if (!pwd.matches(pwdRegex)) {
                    pwdTips.setText("请输入六位数字密码");
                    return;
                } else {
                    pwdTips.setForeground(Color.green);
                    pwdTips.setText("✔");
                }

                pwdAgainTips.setText("");
                if (!pwdAgain.equals(pwd)) {
                    pwdAgainTips.setText("两次输入密码不一样");
                    return;
                } else {
                    pwdAgainTips.setForeground(Color.green);
                    pwdAgainTips.setText("✔");
                }

                nnTips.setText("");
                if (!nn.matches(nnRegex)) {
                    nnTips.setText("请输入4到8位单词字符");
                    return;
                } else {
                    nnTips.setForeground(Color.green);
                    nnTips.setText("✔");
                }

                //4、 TODO 传入数据库
                saveUserInfo(regUser);

                //5、 TODO 注册成功跳转登录页面
                dispose();
                new LoginFrame();

            }
        });



    }

    /**
     * @return
     * @Param
     * @description 将数据保存至数据库
     * @date 2019/5/1 10:42
     */
    private void saveUserInfo(User regUser) {
        Connection conn = DBUtil.getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "insert into administration_info values(null," +
                    "'" + regUser.getPhoneNUmber() + "','" + regUser.getPwd() + "'" +
                    ",'" + regUser.getNickname() + "')";
            int count = stat.executeUpdate(sql);
            if (count >= 1) {
                System.out.println("successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }

    }

    /**
     * @return
     * @Param
     * @description 手机号查重
     * @date 2019/5/1 10:28
     */
    private boolean checkPnRepeat(String pn) {
        Connection conn = DBUtil.getPoolConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "select count(1) from administration_info where phonenum = '" + pn + "'";
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            if (rs.getInt(1) <= 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    /**
     * @return
     * @Param
     * @description 返回键
     * @date 2019/4/30 16:52
     */
    private void addBackBtnAction() {

    }

    /**
     * @return
     * @Param
     * @description 窗体初始化
     * @date 2019/4/30 16:25
     */
    private void initFrame() {
        this.setTitle("欢迎注册");
        this.setSize(500, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    /**
     * @return
     * @Param
     * @description 组件初始化
     * @date 2019/4/30 16:26
     */
    private void initComponents() {
        Font font = new Font("微软雅黑", Font.BOLD, 32);

        //手机号
        pnText = new JLabel("手机号");
        pnText.setFont(font);
        pnText.setBounds(50, 50, 150, 50);

        //登录密码
        pwdText = new JLabel("登录密码");
        pwdText.setFont(font);
        pwdText.setBounds(50, 150, 150, 50);

        //确认密码
        pwdAgainText = new JLabel("确认密码");
        pwdAgainText.setFont(font);
        pwdAgainText.setBounds(50, 250, 150, 50);

        //昵称
        nnText = new JLabel("昵称");
        nnText.setFont(font);
        nnText.setBounds(50, 350, 150, 50);

        //
        pnField = new JTextField();
        pnField.setBounds(200, 50, 150, 50);
        pwdField = new JTextField();
        pwdField.setBounds(200, 150, 150, 50);
        pwdAgainField = new JTextField();
        pwdAgainField.setBounds(200, 250, 150, 50);
        nnField = new JTextField();
        nnField.setBounds(200, 350, 150, 50);

        regBtn = new JButton("注册");
        regBtn.setBounds(200, 450, 100, 50);

        backBtn = new JButton("返回");
        backBtn.setBounds(100, 450, 100, 50);

        pnTips = new JLabel();
        pnTips.setForeground(Color.red);
        pnTips.setBounds(350, 50, 150, 50);

        pwdTips = new JLabel();
        pwdTips.setForeground(Color.red);
        pwdTips.setBounds(350, 150, 150, 50);

        pwdAgainTips = new JLabel();
        pwdAgainTips.setForeground(Color.red);
        pwdAgainTips.setBounds(350, 250, 150, 50);

        nnTips = new JLabel();
        nnTips.setForeground(Color.red);
        nnTips.setBounds(350, 350, 150, 50);

        mainPanle = new JLabel();
        mainPanle.add(pnText);
        mainPanle.add(pwdText);
        mainPanle.add(pwdAgainText);
        mainPanle.add(nnText);


        mainPanle.add(pnField);
        mainPanle.add(pwdField);
        mainPanle.add(pwdAgainField);
        mainPanle.add(nnField);

        mainPanle.add(regBtn);
        mainPanle.add(backBtn);

        mainPanle.add(pnTips);
        mainPanle.add(pwdTips);
        mainPanle.add(pwdAgainTips);
        mainPanle.add(nnTips);

        this.add(mainPanle);
    }

    public static void main(String[] args) {
        new RegisterFrame();
    }
}
