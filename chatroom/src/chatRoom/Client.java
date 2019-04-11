/**
 * @Author xlyu
 * @Date 2019/4/11
 * @Description
 */
package chatRoom;

import javax.swing.*;

/**
 * @program: chatRoom
 * @description:
 * @author: xlyu
 * @create: 2019-04-11 11:44
 **/
public class Client extends JFrame {
    private TopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;

    public Client() {
        /**
         * 初始化组件
         */
        top = new TopPanel();
        center = new CenterPanel();
        bottom = new BottomPanel();

        add(top, "North");
        add(center, "Center");
        add(bottom, "South");

        //初始化窗体配置信息
        initFrameConfig();
    }

    private void initFrameConfig() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Client();
    }
}
