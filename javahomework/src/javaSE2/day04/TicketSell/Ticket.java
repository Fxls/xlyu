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
public class Ticket {
    private int tNum = 100;

    public void sellTicket() {
        if (!isSellOver()) {
            System.out.println(Thread.currentThread().getName() + "：卖出的票号为--" + tNum);
            tNum--;
        }
    }

    public boolean isSellOver() {
        if (tNum <= 0) {
            return true;
        }
        return false;
    }
}
