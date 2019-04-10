/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 龟兔赛跑
 * @author: xlyu
 * @create: 2019-04-09 20:07
 **/
public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            System.out.println(Thread.currentThread().getName() + "--" + i);
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
        }
    }

    private static boolean gameOver(int i) {
        if (winner != null) {
            return true;
        } else {
            if (i == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner--" + winner);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "t").start();
        new Thread(race, "r").start();
    }
}
