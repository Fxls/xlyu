/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: chatRoom
 * @description: 上部面板组件
 * @author: xlyu
 * @create: 2019-04-11 19:21
 **/
public class TopPanel extends JPanel {
    //ip
    private JLabel ip;
    //内容port
    private JLabel port;
    //内容nickname
    private JLabel nickname;
    //连接按钮
    private JButton connBtn;
    //断开按钮
    private JButton disconnBtn;
    //ip输入框
    private JTextField ipText;
    //port输入框
    private JTextField portText;
    //昵称输入框
    private JTextField nicknameText;

    public TopPanel() {

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

    public JLabel getPort() {
        return port;
    }

    public void setPort(JLabel port) {
        this.port = port;
    }

    public JLabel getNickname() {
        return nickname;
    }

    public void setNickname(JLabel nickname) {
        this.nickname = nickname;
    }

    public JButton getConnBtn() {
        return connBtn;
    }

    public void setConnBtn(JButton connBtn) {
        this.connBtn = connBtn;
    }

    public JButton getDisconnBtn() {
        return disconnBtn;
    }

    public void setDisconnBtn(JButton disconnBtn) {
        this.disconnBtn = disconnBtn;
    }

    public JTextField getIpText() {
        return ipText;
    }

    public void setIpText(JTextField ipText) {
        this.ipText = ipText;
    }

    public JTextField getPortText() {
        return portText;
    }

    public void setPortText(JTextField portText) {
        this.portText = portText;
    }

    public JTextField getNicknameText() {
        return nicknameText;
    }

    public void setNicknameText(JTextField nicknameText) {
        this.nicknameText = nicknameText;
    }
}
