/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05;

/**
 * @program: javaHomework
 * @description: 建设银行
 * @author: xlyu
 * @create: 2019-03-18 19:05
 **/
public class CCB extends BankInterface implements InterfaceBank {
    public CCB() {
        super("CCB");
    }

    public void name() {
        System.out.println("i am CCB");
        System.out.println("我还有缴费功能");
    }


    @Override
    public void run() {

    }

    public static void main(String[] args) {
        CCB ccb = new CCB();
        System.out.println(CCB.FUNCTION);
        ccb.name();
        ccb.run();
    }
}
