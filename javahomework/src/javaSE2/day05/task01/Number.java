/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05.task01;

/**
 * @program: javaHomework
 * @description: 数字操作
 * @author: xlyu
 * @create: 2019-04-10 17:02
 **/
public class Number implements Runnable {
    private Object lock;

    public Number(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 1; i < 53; i++) {
                if (i > 1 && i % 2 == 1) {
                    System.out.print("");
                }
                System.out.print(i);
                if (i % 2 == 0) {

                    //先释放锁,唤醒其他线程,再使本线程阻塞
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
