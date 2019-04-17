/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom.gui;

import javax.swing.*;

/**
 * @program: chatRoom
 * @description: 上部面板组件
 * @author: xlyu
 * @create: 2019-04-11 19:21
 **/
public class TopPanel extends JPanel {

    //内容port
    protected JLabel port;

    //连接按钮
    protected JButton connBtn;
    //断开按钮
    protected JButton disconnBtn;
    //


    //port输入框
    protected JTextField portText;


    public TopPanel() {

    }

    public JLabel getPort() {
        return port;
    }

    public void setPort(JLabel port) {
        this.port = port;
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

    public JTextField getPortText() {
        return portText;
    }

    public void setPortText(JTextField portText) {
        this.portText = portText;
    }
}
