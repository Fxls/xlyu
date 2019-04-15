/**
 * @Author xlyu
 * @Date 2019/4/12
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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: chatRoom
 * @description: 服务器
 * @author: xlyu
 * @create: 2019-04-12 14:42
 **/
public class Server extends JFrame {
    private ServerTopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;

    private int port;
    private ServerSocket server;

    private Map<String, Socket> clients = new HashMap<>();

    /**
     * 服务器发送的协议数据类型
     */
    private static final String BRORDCASR_ONLINE_USERS = "onlineUsers";

    //客户端的数据传送协议
    private static final String CLIENT_TO_CLIENT = "clientToClient";

    private static final String PUBLIC_TALK = "everybodyHappyTalk";

    private static final String ANNOUNCEMENT = "群通告";

    private static final String INTERRUPT_REQUEST = "中断请求";

    private static final String SERVER_STOP = "serverStop";

    private static volatile boolean exit = false;

    private Server() {
        //组件初始化
        initComponent();
        //窗体初始化
        initFrameConfig();
        //button事件
        addBtnAction();


    }

    private void addBtnAction() {
        //连接按钮事件
        addConnAction();
    }

    private void addConnAction() {
        //start响应
        top.getConnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //1、获取端口号
                String portStr = top.getPortText().getText();
                try {
                    port = Integer.valueOf(portStr);
                } catch (NumberFormatException e1) {
                    CenterPanel.getContenArea().append(buildNoticeMsg("请检查端口"));
                    return;
                }


                /**
                 * 对端口进行校验（待做）
                 */

                if (portJudge(portStr) == false) {
                    CenterPanel.getContenArea().append(buildNoticeMsg("端口错误"));
                } else {

                    //创建服务端ServerSocket
                    try {
                        server = new ServerSocket(port);
                        exit = false;
                        CenterPanel.getContenArea().append(buildNoticeMsg("服务器启动成功"));
                    } catch (IOException e1) {
                        CenterPanel.getContenArea().append(buildNoticeMsg("服务器启动失败"));
                    }


                    top.disconnBtn.setEnabled(true);
                    top.connBtn.setEnabled(false);
                    bottom.getSendBtn().setEnabled(true);

                    //监听端口

                    //监听线程，循环监听是否有客户端连接
                    Thread acceptTh = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (exit == false) {
                                try {


                                    Socket client = server.accept();

                                    //关闭服务器的操作


                                    //读取客户端昵称
                                    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

                                    String nickname = br.readLine();

                                    //把已经连接的客户昵称输入至用户列表中

                                    CenterPanel.getListModel().addElement(nickname);


                                    //将登录成功的用户输出到主面板上
                                    CenterPanel.getContenArea().append(buildNoticeMsg(nickname + "加入群聊"));

                                    //获取用户列表的昵称
                                    StringBuilder sb = new StringBuilder();
                                    //在线人数
                                    int olineCount = CenterPanel.getListModel().getSize();

                                    //遍历赋值
                                    for (int i = 0; i < olineCount; i++) {
                                        String users = (String) CenterPanel.getListModel().get(i);
                                        sb.append(users).append(",");
                                    }


                                    /**
                                     * 服务器向客户端发送的协议数据
                                     */
                                    String sendMsg = buildServerSendMsg(BRORDCASR_ONLINE_USERS, "sever", sb.toString());

                                    //将客户端昵称和该客户端对象成对放入Map.clients中
                                    clients.put(nickname, client);

                                    //使用entrySet遍历所有的客户端
                                    Set<Map.Entry<String, Socket>> entrySet = clients.entrySet();

                                    //增强for循环
                                    for (Map.Entry<String, Socket> entry : entrySet) {
                                        Socket tips = entry.getValue();
                                        PrintWriter tipsPw = null;
                                        try {
                                            tipsPw = new PrintWriter(tips.getOutputStream(), true);
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                        tipsPw.println(sendMsg);
                                    }

                                    //TODO send键发送广播消息
                                    bottom.getSendBtn().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //获取send文本框中内容
                                            String sendText = bottom.getSendText().getText();
                                            String nickname = "everyone";
                                            sendText = buildServerSendMsg(ANNOUNCEMENT, nickname, sendText);
                                            try {
                                                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                                                pw.println(sendText);
                                            } catch (IOException e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                    });


                                    /**
                                     * 创建接收信息的线程
                                     */
                                    Thread receiveTh = new Thread(new Runnable() {
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
                                                        case PUBLIC_TALK:
                                                            CenterPanel.getContenArea().append(buildReceiveNoticeMsg(nickname, content));
                                                            for (Map.Entry<String, Socket> entry : entrySet) {
                                                                Socket tips = entry.getValue();
                                                                PrintWriter pwPub = new PrintWriter(tips.getOutputStream(), true);
                                                                pwPub.println(buildServerSendMsg(PUBLIC_TALK, nickname, content));
                                                            }
                                                            break;
                                                        case CLIENT_TO_CLIENT:
                                                            //获取name，然后发给指定name
                                                            CenterPanel.getContenArea().append(buildReceiveNoticeMsg(nickname, content));
                                                            for (Map.Entry<String, Socket> entry : entrySet) {
                                                                //遍历键值对，找到指定客户端发送私聊内容
                                                                if (entry.getKey().equals(name)) {
                                                                    Socket client = entry.getValue();
                                                                    PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                                                                    pw.println(buildServerSendMsg(CLIENT_TO_CLIENT, nickname, content));
                                                                }
                                                            }
                                                            break;
                                                        case INTERRUPT_REQUEST:

                                                            //TODO 接收中断请求后，清空相关的所有内容
                                                            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);

                                                            clients.remove(name, client);
                                                            CenterPanel.getListModel().removeElement(name);
                                                            StringBuilder sb = new StringBuilder();
                                                            //在线人数
                                                            int olineCount = CenterPanel.getListModel().getSize();
                                                            for (int i = 0; i < olineCount; i++) {
                                                                String users = (String) CenterPanel.getListModel().get(i);
                                                                sb.append(users).append(",");
                                                            }
                                                            String sendMsg = buildServerSendMsg(BRORDCASR_ONLINE_USERS, "sever", sb.toString());
                                                            for (Map.Entry<String, Socket> entry : entrySet) {
                                                                Socket tips = entry.getValue();
                                                                PrintWriter tipsPw = null;
                                                                try {
                                                                    tipsPw = new PrintWriter(tips.getOutputStream(), true);
                                                                } catch (IOException e1) {
                                                                    e1.printStackTrace();
                                                                }
                                                                tipsPw.println(sendMsg);
                                                            }

                                                            CenterPanel.getContenArea().append(buildNoticeMsg(name + "已经断开与服务器的连接"));
                                                            pw.println(buildServerSendMsg(INTERRUPT_REQUEST, name, INTERRUPT_REQUEST));

                                                            break;
                                                    }
                                                } catch (IOException e1) {
                                                    break;
                                                }
                                            }
                                        }
                                    });
                                    receiveTh.start();

                                    top.disconnBtn.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            //连接按键可见
                                            top.getConnBtn().setEnabled(true);
                                            //发送按键不可见
                                            bottom.getSendBtn().setEnabled(false);
                                            //断开不可见
                                            top.getDisconnBtn().setEnabled(false);
                                            try {
                                                CenterPanel.getListModel().clear();
                                                Thread.sleep(5000);
                                                for (Map.Entry<String, Socket> entry : entrySet) {
                                                    Socket tips = entry.getValue();
                                                    PrintWriter pwPub = new PrintWriter(tips.getOutputStream(), true);
                                                    pwPub.println(buildServerSendMsg(SERVER_STOP, "everyone", SERVER_STOP));
                                                }


                                                Thread.sleep(5000);
                                                System.exit(0);

                                            } catch (IOException e1) {
                                                e1.printStackTrace();
                                            } catch (InterruptedException e1) {
                                                e1.printStackTrace();
                                            }
                                        }
                                    });


                                } catch (IOException e1) {
                                    CenterPanel.getContenArea().append(buildNoticeMsg("连接失败"));

                                }

                                CenterPanel.getContenArea().append(buildNoticeMsg("连接成功"));
                            }
                            if (exit == true) {
                                return;
                            }
                        }

                    });
                    acceptTh.start();
                }
            }
        });
    }


    private String parseMsgContent(String receive) {
        int index = receive.indexOf(":");
        return receive.substring(index + 1);
    }

    private String parseMsgName(String receive) {
        int index1 = receive.indexOf("$");
        int index2 = receive.indexOf(":");
        return receive.substring(index1 + 1, index2);
    }

    private String parseMsgType(String receive) {
        int index = receive.indexOf("$");
        return receive.substring(0, index);
    }

    /**
     * @return
     * @Param
     * @description 服务器向客户端发送的协议数据
     * @date 2019/4/12 16:31
     */
    private String buildServerSendMsg(String type, String fromName, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append("$").append(fromName).append(":").append(content);
        return sb.toString();
    }

    /**
     * @return java.lang.String
     * @Param
     * @description 主窗口文本显示格式--2(客户发来的信息如何显示)
     * @date 2019/4/12 15:39
     */
    private String buildReceiveNoticeMsg(String nicknameMsg, String receiveMsg) {
        StringBuilder sb = new StringBuilder();
        sb.append(nicknameMsg).append(" :").append("\n").append("\t").append(receiveMsg).append("\n");
        return sb.toString();

    }

    /**
     * @return
     * @Param
     * @description 主窗口文本显示格式--1（系统消息显示格式）
     * @date 2019/4/12 15:27
     */
    private String buildNoticeMsg(String notice) {
        StringBuilder sb = new StringBuilder();
        sb.append("[提示信息]:").append(notice).append("\n");
        return sb.toString();
    }

    private void initFrameConfig() {
        this.setTitle("QQ服务器");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
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
        if (portStr == null) {
            return false;
        }
        CenterPanel.getContenArea().append(buildNoticeMsg("请输入正确的端口号"));
        return false;
    }

    /**
     * @return
     * @Param
     * @description 初始化组件
     * @date 2019/4/12 14:55
     */
    private void initComponent() {

        //初始化组件
        top = new ServerTopPanel();
        center = new CenterPanel();
        bottom = new BottomPanel();

        add(top, "North");
        add(center, "Center");
        add(bottom, "South");
    }

    public static void main(String[] args) {
        new Server();
    }
}
