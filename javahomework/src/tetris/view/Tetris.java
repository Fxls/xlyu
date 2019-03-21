/**
 * @Author xlyu
 * @Date 2019/3/19 0019
 * @Description
 */
package tetris.view;

import sun.applet.AppletAudioClip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: javahomework
 * @description: 俄罗斯方块界面元素(具体的操作方法等)
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
    //常量：单元格列起点
    private static final int COL_START = 1;
    //常量：单元格规格
    private static final int ROW = 18;
    private static final int COL = 9;
    //引用类型创建移动方块和预测方块
    private Tetrimino movingTetrimino;
    private Tetrimino nextTetrimino;
    //定时器引用类型（java.until.Timer）
    private Timer timer;
    private Timer timerAuttoDrop;
    //二维数组，存储墙体中的方块
    private Cell[][] wall;
    //消行数
    private int rowDelete;
    //这个整数组用来存储游戏难度等级
    private int[] levArr = {1, 2, 3, 4, 5};



    private int levNum() {
        int levNum;
        if (rowDelete >= 40) {
            levNum = levArr[4];
        } else if (rowDelete >= 30) {
            levNum = levArr[3];
        } else if (rowDelete >= 20) {
            levNum = levArr[2];
        } else if (rowDelete >= 10) {
            levNum = levArr[1];
        } else {
            levNum = levArr[0];
        }
        return levNum;
    }


    private int levTime() {
        int lev;
        if (rowDelete >= 40) {
            lev = 80;
        } else if (rowDelete >= 30) {
            lev = 310;
        } else if (rowDelete >= 20) {
            lev = 540;
        } else if (rowDelete >= 10) {
            lev = 770;
        } else {
            lev = 1000;
        }
        return lev;

    }


    /**
     * @return
     * @Param
     * @description TODO 构造器
     * @date 2019/3/19 0019 15:42
     */
    public Tetris() {
        try {
            URL cb;
            File f = new File("E:\\soft\\git\\xlyu\\javahomework\\resource\\backmusic.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        movingTetrimino = generateRandomTerimino();
        nextTetrimino = generateRandomTerimino();
        wall = new Cell[ROW][COL];//空墙体
        addKeyBordListener();//Alt+Enter     create 一个键盘监听事件
        timer = new Timer();
        //匿名内部类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();//重画方法
            }
        }, 0, 20);//休眠期

        /**
         * @Param
         * @description TODO 控制自动下落方块的定时器
         * @date 2019/3/20 0020 19:16
         * @return
         */

        timerAuttoDrop = new Timer();
        timerAuttoDrop.schedule(new TimerTask() {
            @Override
            public void run() {

                //此处方法与键盘监听中使用的方法一样
                if (!isReachBottom(movingTetrimino)) {
                    movingTetrimino.drop();
                    if (hitWall(movingTetrimino)) {
                        movingTetrimino.drop(-1);
                        joinWall(movingTetrimino);
                    }
                } else {
                    joinWall(movingTetrimino);
                }


            }
        }, 0, levTime());
    }

    /**
     * @return
     * @Param
     * @description TODO 添加定点方块组合
     * @date 2019/3/20 0020 20:11
     */

    public void joinWall(Tetrimino t) {
        Cell[] cells = t.cells;
        for (int i = 0; i < cells.length; i++) {
            int row = cells[i].row;
            int col = cells[i].col;
            wall[row - 1][col - 1] = cells[i];//对应Wall的索引下标
        }

        for (int row = 0; row < ROW; row++) {
            boolean isNeedDelete = true;
            for (int col = 0; col < COL; col++) {
                if (wall[row][col] == null) {//一行没有填满（列元素未全部填充）
                    isNeedDelete = false;
                    break;
                }
            }

            //消行
            if (isNeedDelete) {
                rowDelete++;//消行次数每进入一次if加一次
                wall[row] = new Cell[COL];
                //从下往上遍历
                for (int i = row - 1; i >= 0; i--) {
                    for (int j = 0; j < COL; j++) {
                        if (wall[i][j] != null) {
                            wall[i][j].drop();//满行删除一整行
                        }
                    }
                    wall[i + 1] = wall[i];//将上行的方块付给下行
                }
                wall[0] = new Cell[COL];
            }
        }
        movingTetrimino = nextTetrimino;
        nextTetrimino = generateRandomTerimino();
    }

    /**
     * @return
     * @Param
     * @description TODO 撞墙的判断方法
     * @date 2019/3/20 0020 20:12
     */

    private boolean hitWall(Tetrimino t) {
        Cell[] cells = t.cells;
        for (int i = 0; i < cells.length; i++) {
            int row = cells[i].row;
            int col = cells[i].col;
            if (wall[row - 1][col - 1] != null) {
                return true;

            }
        }
        return false;
    }

    /**
     * @return
     * @Param
     * @description TODO 从构造器中创建而来的addKeyBordListener方法，其中添加了键盘监听
     * @date 2019/3/19 0019 17:00
     */

    private void addKeyBordListener() {
        //键盘监听
        this.addKeyListener(new KeyAdapter() {//匿名内部类
            @Override
            //重写keyPressed方法
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int code = e.getKeyCode();//接收键入值
                switch (code) {
                    case KeyEvent.VK_SPACE:

                        movingTetrimino.rotate(true);
                        if (isOutBoundary(movingTetrimino)) {
                            movingTetrimino.rotate(false);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!isReachBottom(movingTetrimino)) {
                            movingTetrimino.drop();
                            if (hitWall(movingTetrimino)) {
                                movingTetrimino.drop(-1);
                                joinWall(movingTetrimino);
                            }
                        } else {
                            joinWall(movingTetrimino);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (!isReachLeftBoundary(movingTetrimino)) {
                            movingTetrimino.moveLeft();
                            if (hitWall(movingTetrimino)) {
                                movingTetrimino.moveRight();
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!isReachRightBoundary(movingTetrimino)) {
                            movingTetrimino.moveRight();
                            if (hitWall(movingTetrimino)) {
                                movingTetrimino.moveLeft();
                            }
                        }
                        break;

                }
                try {
                    URL cb;
                    File f = new File("E:\\soft\\git\\xlyu\\javahomework\\resource\\press.wav");
                    cb = f.toURL();
                    AudioClip aau;
                    aau = Applet.newAudioClip(cb);
                    aau.play();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //聚焦
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);

    }

    /**
     * @return
     * @Param
     * @description TODO 越界判断
     * @date 2019/3/20 0020 20:12
     */

    private boolean isOutBoundary(Tetrimino t) {
        for (int i = 0; i < movingTetrimino.cells.length; i++) {
            if (movingTetrimino.cells[i].row < 1 ||//上边界
                    movingTetrimino.cells[i].row > ROW ||//下边界
                    movingTetrimino.cells[i].col < COL_START ||//左边界
                    movingTetrimino.cells[i].col > COL) {//右边界
                //越界
                return true;
            }
        }
        // 未越界
        return false;

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
//        int randomNum = 0;
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

            default://监测机制
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
        paintWall(g);
        Font font = new Font("黑体", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("消除的行数：" + Integer.toString(rowDelete), 300, 285);
        g.drawString("得分：" + Integer.toString(rowDelete * 10), 300, 230);
        Font font2 = new Font("黑体", Font.BOLD, 18);
        g.setFont(font2);
        g.drawString("等级/" + Integer.toString(levNum()), 300, 175);
        g.drawString("速度/" + Integer.toString(levTime()), 380, 175);
        g.drawString("ms", 480, 175);
    }

    private void paintWall(Graphics g) {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (wall[row][col] != null) {
                    wall[row][col].paint(g);
                }
            }

        }
    }
}
