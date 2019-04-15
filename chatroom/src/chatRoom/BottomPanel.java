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
 * @description: 底部面板
 * @author: xlyu
 * @create: 2019-04-11 19:48
 **/
public class BottomPanel extends JPanel {
    private JTextField sendText;
    private JButton sendBtn;

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
        sendText = new JTextField();
        sendBtn.setBackground(new Color(0x3333ff));

        //面板布局
        setLayout(new BorderLayout());

        add(sendText, "Center");
        add(sendBtn, "East");

        //边框
        setBorder(new TitledBorder("send area"));
        setBackground(new Color(0xBBFFFF));

        sendBtn.setEnabled(false);
    }
}
