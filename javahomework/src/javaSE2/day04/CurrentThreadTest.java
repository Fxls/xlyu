/**
 * @Author xlyu
 * @Date 2019/4/9
 * @Description
 */
package javaSE2.day04;

/**
 * @program: javaHomework
 * @description: 观察currentThread
 * @author: xlyu
 * @create: 2019-04-09 15:10
 **/
public class CurrentThreadTest {

    /**
     * 创建获取currentThread的方法
     */
    public static void testCurrent() {
        Thread ct = Thread.currentThread();
        System.out.println(ct);
    }

    public static void main(String[] args) {

        //main中调用testCurrent
        testCurrent();

        //重写run方法中调用testCurrent
        Thread t = new Thread(() -> testCurrent());
        t.start();

        /**
         * 打印结果
         *      Thread[main,5,main]
         *      Thread[Thread-0,5,main]
         */
    }
}
