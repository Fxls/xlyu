/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day04.TicketSell;

/**
 * @program: javaHomework
 * @description: 票号
 * @author: xlyu
 * @create: 2019-04-10 14:02
 **/
public class TicketSynchroinzed {
    private int tNum = 100;

    /**
     * synchronized关键字可以对费静态方法直接使用，也可以在方法体内部使用，在内部使用时（this）
     * 在对费静态方法使用时，要注意锁的是类对象，静态方法内部（当前类.class）
     */
    public synchronized void sellTicket() {
        if (!isSellOver()) {
            System.out.println(Thread.currentThread().getName() + "：卖出的票号为--" + tNum);
            tNum--;
        }
    }

    public synchronized boolean isSellOver() {
        if (tNum <= 0) {
            return true;
        }
        return false;
    }
}
