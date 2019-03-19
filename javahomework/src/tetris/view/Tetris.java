/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: javahomework
 * @description: 俄罗斯方块界面元素
 * @author: xlyu
 * @create: 2019-03-19 12:59
 **/
public class Tetris extends JPanel {
    //图片资源
    private static Image backImage;
    private static Image tbackImage;
    private static Image obackImage;
    private static Image sbackImage;
    private static Image zbackImage;
    private static Image lbackImage;
    private static Image jbackImage;
    private static Image ibackImage;
    //常量：单元格规格
    private static final int COL_START = 1;
    private static final int ROW = 18;
    private static final int COL = 9;
    //引用类型创建移动方块和预测方块
    private Tetrimino movingTetrimino;
    private Tetrimino nextTetrimino;
    private Timer timer;

    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/19 0019 15:42
     */
    public Tetris() {
        movingTetrimino = generateRandomTerimino();
        nextTetrimino = generateRandomTerimino();
        addKeyBordListener();//Alt+Enter     create 一个键盘监听事件
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 20);
    }

    private void addKeyBordListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_DOWN:
                        if (!isReachBottom(movingTetrimino)) {
                            movingTetrimino.drop();
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (!isReachLeftBoundary(movingTetrimino)) {
                            movingTetrimino.moveLeft();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!isReachRightBoundary(movingTetrimino)) {
                            movingTetrimino.moveRight();
                        }
                        break;

                }
            }
        });
        //聚焦
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);

    }

    /**
     * @return boolean
     * @Param tetrimino={}
     * @description TODO 下边界
     * @date 2019/3/19 0019 16:05
     */
    public boolean isReachBottom(Tetrimino tetrimino) {

        Cell[] cells = tetrimino.cells;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].row >= ROW) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return boolean
     * @Param tetrimino={}
     * @description TODO 左边界
     * @date 2019/3/19 0019 16:05
     */
    public boolean isReachLeftBoundary(Tetrimino tetrimino) {
        Cell[] cells = tetrimino.cells;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].col <= COL_START) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return boolean
     * @Param tetrimino={}
     * @description TODO 右边界
     * @date 2019/3/19 0019 16:05
     */
    public boolean isReachRightBoundary(Tetrimino tetrimino) {
        Cell[] cells = tetrimino.cells;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].col >= COL) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Param
     * @description TODO static代码块，加载静态资源
     * @date 2019/3/19 0019 15:37
     * @return
     */
    static {
        /**
         * @Param
         * @description TODO try-catch捕获异常
         * @date 2019/3/19 0019 15:39
         * @return
         */

        try {
            backImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("TETRIS.png"));
            tbackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("T.png"));
            obackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("O.png"));
            sbackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("S.png"));
            zbackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("Z.png"));
            lbackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("L.png"));
            jbackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("J.png"));
            ibackImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("I.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * @return
     * @Param
     * @description TODO 生成随机方块组合
     * @date 2019/3/19 0019 15:39
     */

    public Tetrimino generateRandomTerimino() {
        int randomNum = (int) (Math.random() * 7);
        switch (randomNum) {
            case 0:
                return new TetriminoI(1, 5, ibackImage);
            case 1:
                return new TetriminoJ(1, 5, jbackImage);
            case 2:
                return new TetriminoL(1, 5, lbackImage);
            case 3:
                return new TetriminoO(1, 5, obackImage);
            case 4:
                return new TetriminoS(1, 5, sbackImage);
            case 5:
                return new TetriminoT(1, 5, tbackImage);
            case 6:
                return new TetriminoZ(1, 5, zbackImage);

            default:
                System.out.println("未知错误");
                return new TetriminoI(1, 5, tbackImage);
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 重写paint方法
     * @date 2019/3/19 0019 15:40
     */

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backImage, 0, 0, null);//添加背景
        movingTetrimino.paint(g);
        nextTetrimino.paint(g, 250, 0);

    }
}
