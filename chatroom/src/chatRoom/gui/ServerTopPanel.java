/**
 * @Author xlyu
 * @Date 2019/4/12
 * @Description
 */
package chatRoom.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: chatRoom
 * @description: 服务端头部面板
 * @author: xlyu
 * @create: 2019-04-12 14:44
 **/
public class ServerTopPanel extends TopPanel {
    public ServerTopPanel() {
        super();

        //初始化组件
        port = new JLabel("port");
        portText = new JTextField();
        connBtn = new JButton("open");
        disconnBtn = new JButton("close");

        //添加组件
        add(port);
        add(portText);
        add(connBtn);
        add(disconnBtn);
        disconnBtn.setEnabled(false);

        /**
         * 面板设置
         */
        setLayout(new GridLayout(1, 4));//布局格式
        setBackground(new Color(0xBBFFFF));
        setBorder(new TitledBorder("Configuration"));//边框
    }
}
