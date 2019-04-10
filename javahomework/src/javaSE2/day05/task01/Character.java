/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05.task01;

/**
 * @program: javaHomework
 * @description: 字母操作
 * @author: xlyu
 * @create: 2019-04-10 17:02
 **/
public class Character implements Runnable {
    private Object lock;

    public Character(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        synchronized (lock) {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print("\t" + c);
                System.out.println();

                //先释放锁,唤醒其他线程,再使本线程阻塞
                lock.notify();

                //最后一次不可以wait，否则会一直阻塞
                if (c < 'z') {
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
