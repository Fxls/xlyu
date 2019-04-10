/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day04.TicketSell;

/**
 * @program: javaHomework
 * @description: 售票窗口
 * @author: xlyu
 * @create: 2019-04-10 14:11
 **/
public class SellSynchroinzed extends Thread {
    public SellSynchroinzed(TicketSynchroinzed ticket) {
        this.ticket = ticket;
    }

    public TicketSynchroinzed ticket;

    @Override
    public void run() {
        while (!ticket.isSellOver()) {
            ticket.sellTicket();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
