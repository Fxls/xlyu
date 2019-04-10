/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05;

/**
 * @program: javaHomework
 * @description: 第二题
 * @author: xlyu
 * @create: 2019-04-10 19:37
 **/


/**
 * 使用三个线程，打印递增数字
 * wait和notifyAll以及synchronized关键字实现
 */
public class Task02 {

    //线程编号
    private static int threadId = 1;

    //起始的打印数字
    private static int number = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Task02.class) {
                    while (number <= 75) {

                        //编号为1，此线程工作
                        if (threadId == 1) {
                            System.out.print(Thread.currentThread().getName() + ":");
                            for (int i = 0; i < 5; i++) {
                                System.out.print("\t" + number++);
                            }
                            System.out.println();
                            //修改线程
                            threadId = 2;

                            //唤醒所有阻塞的线程
                            Task02.class.notifyAll();

                            //打印结束，让这个线程阻塞
                            try {
                                Task02.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //编号不为1，此线程阻塞
                        } else {
                            try {
                                Task02.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Task02.class) {
                    while (number <= 75) {
                        if (threadId == 2) {
                            System.out.print(Thread.currentThread().getName() + ":");
                            for (int i = 0; i < 5; i++) {
                                System.out.print("\t" + number++);
                            }
                            System.out.println();
                            threadId = 3;

                            //唤醒其他线程
                            Task02.class.notifyAll();
                            try {
                                Task02.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                Task02.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Task02.class) {
                    while (number <= 75) {
                        if (threadId == 3) {
                            System.out.print(Thread.currentThread().getName() + ":");
                            for (int i = 0; i < 5; i++) {
                                System.out.print("\t" + number++);
                            }
                            System.out.println();
                            threadId = 1;

                            Task02.class.notifyAll();

                            //最后一次不可以wait，否则会一直阻塞
                            if (number < 76) {
                                try {
                                    Task02.class.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                Task02.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
