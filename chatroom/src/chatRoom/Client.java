/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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

    private static final String PUBLIC_TALK = "everybodyHappyTalk";

    private static final String ANNOUNCEMENT = "群通告";

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
    }


    /**
     * @return
     * @Param
     * @description button响应
     * @date 2019/4/12 14:18
     */
    private void addBtnsAction() {

        //连接按钮响应
        addConnBtnAction();
        //send按钮响应
        addSendBtnAction();
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


                //解析sendText
                if (nickname != null) {
                    sendText = buildClientSendMsg(CLIENT_TO_CLIENT, nickname, sendText);
                } else {
                    nickname = "everyone";
                    sendText = buildClientSendMsg(PUBLIC_TALK, nickname, sendText);
                }

                //输出流发送
                pw.println(sendText);

                String type = parseMsgType(sendText);
                String name = parseMsgName(sendText);
                String content = parseMsgContent(sendText);

                //显示自己发出的内容
                CenterPanel.getContenArea().append(buildSendNoticeMsg(name, content));


            }
        });
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

        StringBuilder sb = new StringBuilder();
        sb.append(nickname).append(" " + "To ").append(toName).append(":").
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

                //获取ip地址
                ip = top.getIpText().getText();

                //获取端口号
                String portStr = top.getPortText().getText();
                port = Integer.valueOf(portStr);

                //获取昵称
                nickname = top.getNicknameText().getText();

                /**
                 * 对输入数据进行校验）
                 */
                if (ipJudge(ip) == false) {
                    return;
                } else if (portJudge(portStr) == false) {
                    return;
                } else if (nicknameJudge(nickname) == false) {
                    return;
                } else {


                    //根据获取的ip和端口号创建客户端Socket
                    try {
                        clientSocket = new Socket(ip, port);
                        pw = new PrintWriter(clientSocket.getOutputStream(), true);
                        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                        //写出用户的昵称
                        pw.println(nickname);

                        /**
                         * 接收服务端的线程
                         */
                        Thread receive = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    try {
                                        //解密
                                        String receive = br.readLine();
                                        String type = parseMsgType(receive);
                                        String name = parseMsgName(receive);
                                        String content = parseMsgContent(receive);

                                        switch (type) {

                                            //广播当前在线成员
                                            case BRORDCASR_ONLINE_USERS:
                                                CenterPanel.getListModel().clear();
                                                String[] onlineUsers = content.split(",");
                                                for (String onlineUser : onlineUsers) {
                                                    CenterPanel.getListModel().addElement(onlineUser);
                                                }
                                                break;
                                            case PUBLIC_TALK:
                                                CenterPanel.getContenArea().append(buildSendNoticeMsg(name, content));
                                                break;
                                            case CLIENT_TO_CLIENT:
                                                //显示别人私发的
                                                CenterPanel.getContenArea().append(buildSendNoticeMsg(name, content));
                                                break;
                                            case ANNOUNCEMENT:
                                                CenterPanel.getContenArea().append(buildNoticeMsg(content));
                                                break;
                                        }


                                    } catch (IOException e1) {
                                        break;
                                    }
                                }
                            }
                        });
                        receive.start();

                    } catch (IOException e1) {
                        e1.printStackTrace();
//                    System.out.println("连接服务器失败");
                        CenterPanel.getContenArea().append(buildNoticeMsg("连接服务器失败！"));
                        return;
                    }
//                System.out.println("成功连接服务器");
                    CenterPanel.getContenArea().append(buildNoticeMsg("连接服务器成功！"));
                }
            }
        });
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
        StringBuilder sb = new StringBuilder();
        sb.append("【系统消息】").append(":").append(string).append("\n");
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

    /**
     * @return
     * @Param
     * @description 主程序入口
     * @date 2019/4/13 10:17
     */
    public static void main(String[] args) {
        new Client();
    }
}
