/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @program: chatRoom
 * @description: 底部面板
 * @author: xlyu
 * @create: 2019-04-11 19:48
 **/
public class BottomPanel extends JPanel {
    private JTextField sendText;
    private JButton sendBtn;
    private JButton sendFileBtn;

    public JButton getSendFileBtn() {
        return sendFileBtn;
    }

    public void setSendFileBtn(JButton sendFileBtn) {
        this.sendFileBtn = sendFileBtn;
    }

    public JTextField getSendText() {
        return sendText;
    }

    public void setSendText(JTextField sendText) {
        this.sendText = sendText;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public void setSendBtn(JButton sendBtn) {
        this.sendBtn = sendBtn;
    }

    public BottomPanel() {
        sendBtn = new JButton("send");
        sendFileBtn = new JButton("sendFile");
        sendText = new JTextField();
        sendBtn.setBackground(new Color(0x3333ff));
        sendFileBtn.setBackground(Color.red);

        //面板布局
        setLayout(new BorderLayout());

        add(sendText, "Center");

        add(sendBtn, "East");
        add(sendFileBtn, "West");

        //边框
        setBorder(new TitledBorder("send area"));
        setBackground(new Color(0xBBFFFF));

        sendBtn.setEnabled(false);
        sendFileBtn.setEnabled(false);
    }
}
