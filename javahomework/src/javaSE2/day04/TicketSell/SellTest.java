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
public class SellTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Sell sell1 = new Sell(ticket);
        Sell sell2 = new Sell(ticket);
        Sell sell3 = new Sell(ticket);
        sell1.start();
        sell2.start();
        sell3.start();
    }
}
