/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom.gui;

import day01.DBUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


/**
 * @program: chatRoom
 * @description:
 * @author: xlyu
 * @create: 2019-04-11 11:44
 **/
public class Client extends JFrame {

    //面板类的一些成员变量
    private ClientTopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;


    //用于执行io操作的变量
    private String ip;
    private String nickname;
    private int port;

    //服务端的数据传送协议
    private static final String BRORDCASR_ONLINE_USERS = "onlineUsers";
    //客户端的数据传送协议
    private static final String CLIENT_TO_CLIENT = "clientToClient";
    //群聊协议
    private static final String PUBLIC_TALK = "everybodyHappyTalk";
    //群通告协议
    private static final String ANNOUNCEMENT = "群通告";
    //客户端断开连接请求协议
    private static final String INTERRUPT_REQUEST = "中断请求";
    //服务器关闭协议
    private static final String SERVER_STOP = "serverStop";
    //文件传送
    private static final String FILETOSOMEONE_SEND = "文件传送(个人)";
    //文件传送
    private static final String FILETOALL_SEND = "文件传送（群体)";
    //服务发送的补丁文件
    private static final String PATCH = "补丁";
    //线程运行标志
    private static volatile boolean exit = false;

    //套接字对象变量
    private Socket clientSocket;

    //iO流变量
    private PrintWriter pw;
    private BufferedReader br;


    /**
     * @return
     * @Param
     * @description 构造器（初始化功能）
     * @date 2019/4/13 9:02
     */
    public Client() {

        //组件初始化
        initComponent();

        //初始化窗体配置信息
        initFrameConfig();

        //按钮添加的响应事件
        addBtnsAction();
        CenterPanel.getContenArea().removeAll();
        Connection conn = DBUtil.getConnection();
        try {
            Statement stat = conn.createStatement();
            String sql = "select * from talk_info";
            ResultSet rs = stat.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(2))
                        .append(rs.getString(3))
                        .append(rs.getString(4))
                        .append(rs.getString(5))
                        .append("\n");
            }
            String str = sb.toString();
            CenterPanel.getContenArea().append(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }



    }


    /**
     * @return
     * @Param
     * @description button响应
     * @date 2019/4/12 14:18
     */
    private void addBtnsAction() {
        initConnBtn();

        //连接按钮响应
//        addConnBtnAction();
        //send按钮响应
        addSendBtnAction();
        //断开按钮响应
//        addDisConnBtnAction();
        //文件发送
        addSendFileBtnAction();
    }

    /**
     * @return
     * @Param
     * @description 发送文件的按钮
     * @date 2019/4/16 18:16
     */
    private void addSendFileBtnAction() {
        bottom.getSendFileBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取文件的路径名，这里需要用户手动输入
                String fileMsg = bottom.getSendText().getText();
                File file = new File(fileMsg);
                if (file.exists() == false) {
                    CenterPanel.getContenArea().append(buildNoticeMsg("系统查找不到你的文件，请检查文件路径名"));
                    return;
                } else {
                    if (file.isDirectory() == true) {
                        CenterPanel.getContenArea().append(buildNoticeMsg("请输入准确的路径名"));
                        return;
                    } else {
                        //发送选中昵称
                        String nickname = (String) CenterPanel.getUserList().getSelectedValue();
                        if (nickname.equals(LoginFrame.getNickname())) {
                            CenterPanel.getContenArea().append(buildNoticeMsg("请不要对自己发送文件"));
                            return;
                        } else if (!nickname.equals(LoginFrame.getNickname())) {
                            if (nickname.equals("All Friends")) {
                                //群发文件
                                fileMsg = buildClientSendMsg(FILETOALL_SEND, "All", fileMsg);
                                pw.println(fileMsg);
                                return;
                            } else {

                                nickname = "every";
                                //私发文件
                                fileMsg = buildClientSendMsg(FILETOSOMEONE_SEND, nickname, fileMsg);
                            }
                        } else {
                            fileMsg = buildClientSendMsg(FILETOALL_SEND, nickname, fileMsg);
                            pw.println(fileMsg);
                            return;
                        }
                        //输出流发送
                        pw.println(fileMsg);
                        String name = parseMsgName(fileMsg);
                        CenterPanel.getContenArea().append(buildNoticeMsg("你给" + nickname + "发送了一个无文件"));


                    }
                }

            }
        });
    }

    /**
     * @return
     * @Param
     * @description 断开按钮的功能实现
     * @date 2019/4/15 11:50
     */
    private void addDisConnBtnAction() {
        top.getDisconnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pw.println(buildClientSendMsg(INTERRUPT_REQUEST, LoginFrame.getNickname(), INTERRUPT_REQUEST));
                //中断请求成功，断开按钮不可用，连接按钮可用
                top.disconnBtn.setEnabled(false);
                top.connBtn.setEnabled(true);
                bottom.getSendBtn().setEnabled(false);
                bottom.getSendFileBtn().setEnabled(false);
            }
        });
    }

    /**
     * @return
     * @Param
     * @description sendButton响应
     * @date 2019/4/12 14:19
     */
    private void addSendBtnAction() {
        bottom.getSendBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取send文本框中内容
                String sendText = bottom.getSendText().getText();
                //发送选中昵称
                String nickname = (String) CenterPanel.getUserList().getSelectedValue();
                /**
                 * 如果选中的是自己的id系统提示信息，如果是其他人进入私聊模式，如果不选默认群聊，选中All Friends进入群聊模式
                 */
                if (nickname != null && nickname.equals(LoginFrame.getNickname())) {
                    CenterPanel.getContenArea().append(buildNoticeMsg("你很无聊☺"));
                    return;
                } else if (!nickname.equals(LoginFrame.getNickname())) {
                    if (nickname.equals("All Friends")) {
                        sendText = buildClientSendMsg(PUBLIC_TALK, "everyone", sendText);
                        pw.println(sendText);
                        return;
                    } else {
                        sendText = buildClientSendMsg(CLIENT_TO_CLIENT, nickname, sendText);
                    }
                } else {
                    nickname = "everyone";
                    sendText = buildClientSendMsg(PUBLIC_TALK, nickname, sendText);
                    pw.println(sendText);
                    return;
                }
                //输出流发送
                pw.println(sendText);
                String name = parseMsgName(sendText);
                String content = parseMsgContent(sendText);
                CenterPanel.getContenArea().append(buildSendNoticeMsg(name, content));
                ToTable(name, content);
            }
        });
    }

    private void ToTable(String toName, String txt) {
        Connection conn = DBUtil.getConnection();
        try {
            Statement stat = conn.createStatement();
            LocalDateTime time = LocalDateTime.now();
            String timeStr = time.toString();
            String sql = "insert into talk_info values(null,'" + timeStr + "','" + LoginFrame.getNickname() + "','" + toName + "','" + txt + "')";
            int count = stat.executeUpdate(sql);
            if (count >= 1) {

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
    }

    /**
     * 客户端的数据发送协议
     *
     * @param type
     * @param toName
     * @param content
     * @return
     */
    private String buildClientSendMsg(String type, String toName, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append("$").append(toName).append(":").append(content);
        return sb.toString();
    }


    /**
     * @return
     * @Param
     * @description 文本区显示内容格式
     * @date 2019/4/13 11:14
     */
    private String buildSendNoticeMsg(String toName, String sendText) {
        LocalDateTime time = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(time + "\t").append(nickname).append(" " + "To ").append(toName).append(":").
                append("\n").append("\t").append(sendText).append("\n");
        return sb.toString();
    }

    private String buildPublicTalk(String name, String sendText) {
        LocalDateTime time = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(time + "\t").append(name).append(" " + "To ").append("everyone").append(":").
                append("\n").append("\t").append(sendText).append("\n");
        return sb.toString();
    }


    /**
     * @return
     * @Param
     * @description 连接Button响应
     * @date 2019/4/12 14:19
     */
    private void addConnBtnAction() {

        JButton connBtn = top.getConnBtn();

        /**
         * 连接按钮添加监听
         */
        connBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                exit = false;
                //连接按钮的初始化工作


            }
        });
    }

    /**
     * @return
     * @Param
     * @description 连接按钮初始化
     * @date 2019/4/16 16:49
     */
    private void initConnBtn() {
        //获取ip地址
        ip = "127.0.0.1";
        //获取端口号
        String portStr = "8888";
        port = Integer.valueOf(portStr);
        //获取昵称
        //TODO 获取该登录用户的昵称
        nickname = LoginFrame.getNickname();


        /**
         * 对输入数据进行校验）
         */
//        if (ipJudge(ip) == false) {
//            return;
//        } else if (portJudge(portStr) == false) {
//            return;
//        } else if (nicknameJudge(nickname) == false) {
//            return;
//        } else {
        //客户端创建
        createSocket();
//        }

    }

    /**
     * @return
     * @Param
     * @description 客户端创建
     * @date 2019/4/16 16:45
     */
    private void createSocket() {
        //根据获取的ip和端口号创建客户端Socket
        try {
            clientSocket = new Socket(ip, port);
            pw = new PrintWriter(clientSocket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //写出用户的昵称
            pw.println(nickname);
            //接收服务端信息
            receiveInfo();
        } catch (IOException e1) {
            e1.printStackTrace();
            CenterPanel.getContenArea().append(buildNoticeMsg("连接服务器失败！"));
            return;
        }
        CenterPanel.getContenArea().append(buildNoticeMsg("连接服务器成功！"));
//        top.connBtn.setEnabled(false);
//        top.disconnBtn.setEnabled(false);
        bottom.getSendBtn().setEnabled(true);
        bottom.getSendFileBtn().setEnabled(true);
    }

    /**
     * @return
     * @Param
     * @description 数据的接收
     * @date 2019/4/16 16:50
     */
    private void receiveInfo() {
        /**
         * 接收服务端的线程
         */
        Thread receive = new Thread(new Runnable() {
            @Override
            public void run() {
                while (exit == false) {
                    try {
                        //解密
                        String receive = br.readLine();
                        String type = parseMsgType(receive);
                        String name = parseMsgName(receive);
                        String content = parseMsgContent(receive);
                        double count = 1.0;
                        switch (type) {
                            //广播当前在线成员
                            case BRORDCASR_ONLINE_USERS:
                                CenterPanel.getListModel().clear();
                                CenterPanel.getListModel().addElement("All Friends");
                                String[] onlineUsers = content.split(",");
                                for (String onlineUser : onlineUsers) {
                                    CenterPanel.getListModel().addElement(onlineUser);
                                }
                                break;
                            //接收数据为群聊
                            case PUBLIC_TALK:
                                CenterPanel.getContenArea().append(buildPublicTalk(name, content));
                                break;
                            //接收数据为私聊
                            case CLIENT_TO_CLIENT:
                                //显示别人私发的
                                CenterPanel.getContenArea().append(buildReceivePrivate(name, content));
                                break;
                            //接收数据为群通告
                            case ANNOUNCEMENT:
                                CenterPanel.getContenArea().append(buildNoticeMsg(content));
                                break;
                            //客户端断连，服务同意
                            case INTERRUPT_REQUEST:
                                //客户端请求断开连接后，服务端返回指令，表示可以断开连接了
                                CenterPanel.getListModel().clear();
                                CenterPanel.getContenArea().append(buildNoticeMsg("您已断开了与服务器的连接"));
                                top.disconnBtn.setEnabled(false);
                                bottom.getSendBtn().setEnabled(false);
                                top.connBtn.setEnabled(true);
                                exit = true;
                                break;
                            //服务器关闭指令
                            case SERVER_STOP:
                                //清空用户列表
                                CenterPanel.getListModel().clear();
                                //延迟五秒关闭客户端
                                CenterPanel.getContenArea().append(buildNoticeMsg("服务器已停止工作,5s后将关闭该客户端"));
                                top.disconnBtn.setEnabled(false);
                                bottom.getSendBtn().setEnabled(false);
                                top.connBtn.setEnabled(true);
                                Thread.sleep(5000);
                                System.exit(0);
                                break;
                            case FILETOALL_SEND:

                                String path = "E:\\soft\\git\\xlyu\\chatRoom\\src\\chatRoom\\receive\\" + count + nickname + "Receive.txt";
                                File file = new File(path);
                                file.createNewFile();
                                FileInputStream fis = new FileInputStream(content);
                                FileOutputStream fos = new FileOutputStream(file);
                                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                                String read = null;
                                String str = "";
                                while ((read = br.readLine()) != null) {
                                    str += read;
                                }
                                PrintWriter pw = new PrintWriter(fos, true);
                                pw.println(str);
                                count++;
                                CenterPanel.getContenArea().append(buildNoticeMsg(name + "给大家发了一个文件"));
                                break;
                            case FILETOSOMEONE_SEND:

                                String path2 = "E:\\soft\\git\\xlyu\\chatRoom\\src\\chatRoom\\receive\\#" + count + nickname + "Receive.txt";
                                File file2 = new File(path2);
                                FileInputStream fis2 = new FileInputStream(content);
                                FileOutputStream fos2 = new FileOutputStream(file2);
                                BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
                                String read2 = null;
                                String str2 = "";
                                while ((read2 = br2.readLine()) != null) {
                                    str2 += read2;
                                }
                                PrintWriter pw2 = new PrintWriter(fos2, true);
                                pw2.println(str2);
                                count++;
                                CenterPanel.getContenArea().append(buildNoticeMsg(name + "给你发了一个文件"));
                                break;
                            case PATCH:
                                String path3 = "E:\\soft\\git\\xlyu\\chatRoom\\src\\chatRoom\\receive\\" + count + nickname + "patch.txt";
                                File file3 = new File(path3);
                                FileInputStream fis3 = new FileInputStream(content);
                                FileOutputStream fos3 = new FileOutputStream(file3);
                                BufferedReader br3 = new BufferedReader(new InputStreamReader(fis3));
                                String read3 = null;
                                String str3 = "";
                                while ((read3 = br3.readLine()) != null) {
                                    str3 += read3;
                                }
                                PrintWriter pw3 = new PrintWriter(fos3, true);
                                pw3.println(str3);
                                count++;
                                CenterPanel.getContenArea().append(buildNoticeMsg("收到一个补丁文件"));
                                break;
                        }
                    } catch (IOException e1) {
                        break;
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                //控制线程
                if (exit == true) {
                    return;
                }

            }

        });
        receive.start();
    }

    private String buildReceivePrivate(String name, String content) {
        LocalDateTime time = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(time + "\t").append(name).append("对我说：").append("\n").append("\t").append(content).append("\n");
        return sb.toString();
    }


    /**
     * @return
     * @Param
     * @description TODO 描述功能
     * @date 2019/4/13 11:27
     */
    private String parseMsgContent(String receive) {

        int index = receive.indexOf(":");
        return receive.substring(index + 1);
    }

    /**
     * @return
     * @Param
     * @description TODO 描述功能
     * @date 2019/4/13 11:24
     */
    private String parseMsgName(String receive) {

        int index1 = receive.indexOf("$");
        int index2 = receive.indexOf(":");
        return receive.substring(index1 + 1, index2);
    }

    /**
     * @return
     * @Param
     * @description TODO 描述功能
     * @date 2019/4/13 11:21
     */
    private String parseMsgType(String receive) {

        int index = receive.indexOf("$");
        return receive.substring(0, index);
    }


    /**
     * @return
     * @Param
     * @description 昵称正则校验
     * @date 2019/4/13 10:17
     */
    private boolean nicknameJudge(String nicknameStr) {

        //昵称的正则表达式
        String nicknameRedex = "^[a-zA-Z0-9_-]{4,16}$";
        if (nicknameStr.matches(nicknameRedex)) {
            return true;
        }
        CenterPanel.getContenArea().append(buildNoticeMsg("昵称必须为由字母或数字或下划线或减号组成，且长度为4~16"));
        return false;
    }

    /**
     * @return
     * @Param
     * @description 端口正则校验
     * @date 2019/4/13 10:17
     */
    private boolean portJudge(String portStr) {

        //端口号的正则表示式
        String portRedex = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
        if (portStr.matches(portRedex)) {
            return true;
        }
        CenterPanel.getContenArea().append(buildNoticeMsg("请输入正确的端口号"));
        return false;
    }


    /**
     * @return
     * @Param
     * @description ip地址正则校验
     * @date 2019/4/13 10:18
     */
    private boolean ipJudge(String ip) {

        //ip地址正则表达式，只支持标准格式的输入
        String ipRedex = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}";
        if (ip.matches(ipRedex)) {
            return true;
        }
        CenterPanel.getContenArea().append(buildNoticeMsg("请输入正确的ip地址"));
        return false;

    }

    /**
     * @return
     * @Param
     * @description 主窗口文本显示格式（系统消息的显示格式）
     * @date 2019/4/13 10:15
     */
    private String buildNoticeMsg(String string) {
        LocalDateTime time = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append(time + "\t").append("【系统消息】").append(":").append(string).append("\n");
        return sb.toString();
    }

    /**
     * @return
     * @Param
     * @description 组件初始化
     * @date 2019/4/12 14:20
     */
    private void initComponent() {
        /**
         * 初始化组件
         */
        top = new ClientTopPanel();
        center = new CenterPanel();
        bottom = new BottomPanel();

        add(top, "North");
        add(center, "Center");
        add(bottom, "South");
    }

    /**
     * @return
     * @Param
     * @description 窗体初始化
     * @date 2019/4/12 14:20
     */
    private void initFrameConfig() {
        this.setTitle("腾讯QQ");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

}
