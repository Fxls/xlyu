/**
 * @Author xlyu
 * @Date 2019/4/12
 * @Description
 */
package chatRoom;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: chatRoom
 * @description: 客户端头部面板
 * @author: xlyu
 * @create: 2019-04-12 13:53
 **/
public class ClientTopPanel extends TopPanel {

    //ip
    private JLabel ip;
    //内容nickname
    private JLabel nickname;
    //ip输入框
    private JTextField ipText;
    //昵称输入框
    private JTextField nicknameText;

    public ClientTopPanel() {
        super();

        /**
         * 初始化组件
         */
        ip = new JLabel("IP");
        ipText = new JTextField();
        port = new JLabel("port");
        portText = new JTextField();
        nickname = new JLabel("name");
        nicknameText = new JTextField();
        connBtn = new JButton("conn");
        disconnBtn = new JButton("disConn");

        connBtn.setBackground(new Color(0x3333ff));
        disconnBtn.setBackground(new Color(0x3333ff));

        /**
         * 添加组件到面板
         */
        add(ip);
        add(ipText);
        add(port);
        add(portText);
        add(nickname);
        add(nicknameText);

        add(connBtn);
        add(disconnBtn);


        //开始时，断开按钮处于禁用状态
        disconnBtn.setEnabled(false);


        /**
         * 面板设置
         */
        setLayout(new GridLayout(1, 4));//布局格式
        setBackground(new Color(0xBBFFFF));
        setBorder(new TitledBorder("Configuration"));//边框
    }

    public JLabel getIp() {
        return ip;
    }

    public void setIp(JLabel ip) {
        this.ip = ip;
    }

    public JLabel getNickname() {
        return nickname;
    }

    public void setNickname(JLabel nickname) {
        this.nickname = nickname;
    }

    public JTextField getIpText() {
        return ipText;
    }

    public void setIpText(JTextField ipText) {
        this.ipText = ipText;
    }

    public JTextField getNicknameText() {
        return nicknameText;
    }

    public void setNicknameText(JTextField nicknameText) {
        this.nicknameText = nicknameText;
    }
}
