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
    private static Image readyImage;
    private static Image gameoverImage;
    private static Image pauseImage;
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
    //自动下落定时器
    private Timer timerAutoDrop;
    //二维数组，存储墙体中的方块
    private Cell[][] wall;
    //消行数
    private int rowDelete;
    //接收游戏状态的常量
    private static final int READY = 1;
    private static final int RUNNING = 2;
    private static final int PAUSE = 3;
    private static final int OVER = 4;
    //初始化游戏状态
    private int gameState = READY;
    //声明等级变量
    private int lev = 1;
    //声明分数变量
    private int score = 0;


    /**
     * @return
     * @Param
     * @date 2019/3/19 0019 15:42
     * @description TODO 构造器
     */
    public Tetris() {
        addKeyBordListener();//Alt+Enter     create
        initTimer();//初始化定时器

    }

    /**
     * @return
     * @Param
     * @description TODO 初始化定时器
     * @date 2019/3/21 0021 13:08
     */

    private void initTimer() {
        timer = new Timer();
        //匿名内部类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();//重画方法
            }
        }, 0, 20);//休眠期
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
                    case KeyEvent.VK_E:
                        if (gameState == RUNNING) {
                            nextTetrimino = generateRandomTerimino();
                        }
                        break;
                    case KeyEvent.VK_S://s进入运行状态
                        if (gameState == READY || gameState == OVER) {
                            gameState = RUNNING;
                            startGame();
                        }
                        break;
                    case KeyEvent.VK_P://p进入暂停状态
                        if (gameState == RUNNING) {
                            gameState = PAUSE;
                            timerAutoDrop.cancel();

                        }
                        break;
                    case KeyEvent.VK_C://c继续游戏
                        if (gameState == PAUSE) {
                            gameState = RUNNING;
                            restartTime();
                        }
                        break;
                    case KeyEvent.VK_Q://q退出游戏
                        System.exit(0);
                        break;
                    case KeyEvent.VK_SPACE://space变形
                        if (gameState == RUNNING) {
                            rotate();//变形方法
                        }
                        break;
                    case KeyEvent.VK_DOWN://down下落
                        if (gameState == RUNNING) {
                            moveDown();//下落法
                        }
                        break;
                    case KeyEvent.VK_LEFT://left左移
                        if (gameState == RUNNING) {
                            moveLeft();//左移法
                        }
                        break;
                    case KeyEvent.VK_RIGHT://right右移
                        if (gameState == RUNNING) {
                            moveRight();//右移法
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
     * @return void
     * @Param
     * @description TODO 方块变形方法
     * @date 2019/3/21 0021 14:51
     */
    private void rotate() {
        movingTetrimino.rotate(true);//true时可以变形
        if (isOutBoundary(movingTetrimino) || hitWall(movingTetrimino)) {//越界或者撞墙都不能变形
            movingTetrimino.rotate(false);//修改为false组织变形
        }
    }

    /**
     * @return void
     * @Param
     * @description TODO 方块右移方法
     * @date 2019/3/21 0021 14:53
     */
    private void moveRight() {
        //到达右边界或者碰到墙体禁止右移
        if (!isReachRightBoundary(movingTetrimino)) {
            movingTetrimino.moveRight();
            if (hitWall(movingTetrimino)) {
                movingTetrimino.moveLeft();
            }
        }
    }

    /**
     * @return void
     * @Param
     * @description TODO 方块左移方法
     * @date 2019/3/21 0021 14:57
     */
    private void moveLeft() {
        //到达左边界或者碰到墙体禁止右移
        if (!isReachLeftBoundary(movingTetrimino)) {
            movingTetrimino.moveLeft();
            if (hitWall(movingTetrimino)) {
                movingTetrimino.moveRight();
            }
        }
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
        int removeCount = removeWallRows();//消行法返回的值赋给消行数累计变量
        addScore(removeCount);//统计得分
        restLev();//等级计算
        movingTetrimino = nextTetrimino;
        nextTetrimino = generateRandomTerimino();
        //如果墙体最上一行元素不为空即为游戏结束状态
        for (int col = 1; col <= COL; col++) {
            if (wall[0][col - 1] != null) {
                gameState = OVER;
                return;
            }
        }

    }

    /**
     * @return void
     * @Param
     * @description TODO 等级的算法
     * @date 2019/3/21 0021 15:01
     */
    private void restLev() {
        int temp = lev;
        if (score >= 50 && score <= 100) {
            lev = 2;
        } else if (score > 100 && score <= 200) {
            lev = 3;
        } else if (score > 200 && score <= 300) {
            lev = 4;
        } else if (score > 300) {
            lev = 5;
        } else {
            lev = 1;
        }
        if (temp != lev) {
            //等级如果发生变化，重启及时，重修赋休眠值
            restartTime();
        }
    }

    /**
     * @return void
     * @Param removeCount={通过消行累计计算得分}
     * @description TODO 得分算法
     * @date 2019/3/21 0021 15:04
     */
    private void addScore(int removeCount) {
        switch (removeCount) {
            case 1:
                score += 10;
                break;
            case 2:
                score += 40;
                break;
            case 3:
                score += 80;
                break;
            case 4:
                score += 160;
                break;
        }
    }

    /**
     * @return int
     * @Param
     * @description TODO 消行方法
     * @date 2019/3/21 0021 14:58
     */
    private int removeWallRows() {
        int removeCount = 0;//累计消行初始化值是0！
        for (int row = 0; row < ROW; row++) {
            boolean isNeedDelete = true;//判断是否需要消行
            for (int col = 0; col < COL; col++) {
                if (wall[row][col] == null) {//一行没有填满（列元素未全部填充）
                    isNeedDelete = false;
                    break;
                }
            }
            //消行
            if (isNeedDelete) {
                removeCount++;//如果需要消行就对消行累计值进行累加运算
                rowDelete++;//消行次数每进入一次if加一次
                wall[row] = new Cell[COL];//引用赋值
                //从下往上遍历
                for (int i = row - 1; i >= 0; i--) {
                    for (int j = 0; j < COL; j++) {
                        if (wall[i][j] != null) {
                            wall[i][j].drop();//满行删除一整行
                        }
                    }
                    wall[i + 1] = wall[i];//将上行的方块付给下行
                }
                wall[0] = new Cell[COL];//下降后第一行重新赋值
            }
        }
        return removeCount;
    }

    /**
     * @return boolean
     * @Param t={}
     * @description TODO 撞墙的判断
     * @date 2019/3/21 0021 15:17
     */
    private boolean hitWall(Tetrimino t) {
        Cell[] cells = t.cells;
        for (int i = 0; i < cells.length; i++) {
            int row = cells[i].row;
            int col = cells[i].col;
            if (wall[row - 1][col - 1] != null) {
                //如果为空，此时还未撞墙
                return true;
            }
        }
        return false;
    }

    /**
     * @return void
     * @Param
     * @description TODO 游戏开始的功能，对诸多元素初始化
     * @date 2019/3/21 0021 15:19
     */
    private void startGame() {
        //游戏开始，到结束之前都会一直生成随机方块和移动方块
        movingTetrimino = generateRandomTerimino();
        nextTetrimino = generateRandomTerimino();

        wall = new Cell[ROW][COL];//空墙体
        //初始化消行数
        rowDelete = 0;
        //初始化等级
        lev = 1;
        //初始化得分
        score = 0;
        timerAutoDrop = new Timer();
        //重启自动下落定时器
        restartTime();
    }

    /**
     * @return void
     * @Param
     * @description TODO 重启定时器的方法
     * @date 2019/3/21 0021 15:23
     */
    private void restartTime() {
        timerAutoDrop.cancel();
        timerAutoDrop = new Timer();
        timerAutoDrop.schedule(new TimerTask() {
            @Override
            public void run() {
                moveDown();//下落方法
            }
        }, 0, 100 * (10 - lev));
    }

    /**
     * @return void
     * @Param
     * @description TODO 下落方法
     * @date 2019/3/21 0021 15:24
     */
    private void moveDown() {
        //到达底部和墙体都无法继续下落，无法下落时成为墙体
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
            readyImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("ready.jpg"));
            pauseImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("pause.png"));
            gameoverImage = ImageIO.read(Tetris.class.getClassLoader().getResourceAsStream("game-over.png"));
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
        //不同状态下的paint方法通过switch-case语句实现；注意break的使用
        switch (gameState) {
            case RUNNING:
                paintRunning(g);//运行状态下的绘制方法
                break;
            case READY:
                paintReady(g);//准备状态下的绘制方法
                break;
            case PAUSE:
                paintPause(g);//暂停状态下的绘制方法
                break;
            case OVER:
                paintOver(g);//结束状态下的绘制方法
                break;

        }
    }

    /**
     * @return void
     * @Param g={添加背景图}
     * @description TODO 结束状态下的绘制方法
     * @date 2019/3/21 0021 15:29
     */
    private void paintOver(Graphics g) {
        g.drawImage(gameoverImage, 0, 0, null);
    }

    /**
     * @return void
     * @Param g={添加背景图}
     * @description TODO 暂停状态下的绘制方法
     * @date 2019/3/21 0021 15:29
     */
    private void paintPause(Graphics g) {
        g.drawImage(pauseImage, 0, 0, null);
    }

    /**
     * @return void
     * @Param g={添加背景图}
     * @description TODO 准备状态下的绘制方法
     * @date 2019/3/21 0021 15:31
     */
    private void paintReady(Graphics g) {
        g.drawImage(readyImage, 0, 0, null);
    }

    /**
     * @return void
     * @Param g={添加背景图}
     * @description TODO 运行状态下的绘制方法
     * @date 2019/3/21 0021 15:31
     */
    private void paintRunning(Graphics g) {
        g.drawImage(backImage, 0, 0, null);//添加背景
        movingTetrimino.paint(g);
        nextTetrimino.paint(g, 250, 0);
        paintWall(g);
        paintGameInfo(g);

//        o
    }


    /**
     * @return void
     * @Param g={}
     * @description TODO 界面信息绘制方法
     * @date 2019/3/21 0021 15:32
     */
    private void paintGameInfo(Graphics g) {
        Font font = new Font("黑体", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("消除的行数：" + Integer.toString(rowDelete), 300, 285);
        g.drawString("得分：" + Integer.toString(score), 300, 230);
        g.drawString("游戏等级 : " + Integer.toString(lev), 300, 175);
    }

    /**
     * @return void
     * @Param g={}
     * @description TODO 墙体绘制方法
     * @date 2019/3/21 0021 15:34
     */
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
