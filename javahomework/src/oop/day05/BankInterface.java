/**
 * @Author xlyu
 * @Date 2019/3/18 0018
 * @Description
 */
package oop.day05;

/**
 * @program: javahomework
 * @description: 银联接口
 * @author: xlyu
 * @create: 2019-03-18 19:02
 **/
public abstract class BankInterface {
    public BankInterface(String name) {
    }

    public abstract void name();
}

interface InterfaceBank {
    public static String FUNCTION = "银联";

    void run();
}
