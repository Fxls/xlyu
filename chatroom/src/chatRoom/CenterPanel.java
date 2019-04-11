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
 * @description: 中部面板
 * @author: xlyu
 * @create: 2019-04-11 19:37
 **/
public class CenterPanel extends JSplitPane {
    /**
     * 面板成员组件
     */
    private static JScrollPane leftPanel;
    private static JScrollPane rightPanel;

    //内容显示区
    private static JTextArea contenArea;
    //用户列表
    private static JList userList;
    //存放用户信息，可以在userList中进行显示
    private static DefaultListModel listModel;

    public static JScrollPane getLeftPanel() {
        return leftPanel;
    }

    public static void setLeftPanel(JScrollPane leftPanel) {
        CenterPanel.leftPanel = leftPanel;
    }

    public static JScrollPane getRightPanel() {
        return rightPanel;
    }

    public static void setRightPanel(JScrollPane rightPanel) {
        CenterPanel.rightPanel = rightPanel;
    }

    public static JTextArea getContenArea() {
        return contenArea;
    }

    public static void setContenArea(JTextArea contenArea) {
        CenterPanel.contenArea = contenArea;
    }

    public static JList getUserList() {
        return userList;
    }

    public static void setUserList(JList userList) {
        CenterPanel.userList = userList;
    }

    public static DefaultListModel getListModel() {
        return listModel;
    }

    public static void setListModel(DefaultListModel listModel) {
        CenterPanel.listModel = listModel;
    }

    /**
     * static静态代码块初始化
     */
    static {
        listModel = new DefaultListModel();
        userList = new JList(listModel);
        contenArea = new JTextArea();
        leftPanel = new JScrollPane(contenArea);
        rightPanel = new JScrollPane(userList);
        userList.setBackground(new Color(0x878787));
        contenArea.setBackground(new Color(0xC7EDCC));

        /**
         * 设置边框
         */
        leftPanel.setBorder(new TitledBorder("content area"));
        rightPanel.setBorder(new TitledBorder("user list"));
    }

    public CenterPanel() {
        super(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        setDividerLocation(400);
    }
}
