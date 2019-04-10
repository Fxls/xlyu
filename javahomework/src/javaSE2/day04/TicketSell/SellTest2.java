/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day04.TicketSell;

/**
 * @program: javaHomework
 * @description: 多线程售票
 * @author: xlyu
 * @create: 2019-04-10 14:15
 **/
public class SellTest2 {
    public static void main(String[] args) {
        TicketSynchroinzed ticket = new TicketSynchroinzed();
        SellSynchroinzed sell1 = new SellSynchroinzed(ticket);
        SellSynchroinzed sell2 = new SellSynchroinzed(ticket);
        SellSynchroinzed sell3 = new SellSynchroinzed(ticket);
        sell1.start();
        sell2.start();
        sell3.start();
    }
}
