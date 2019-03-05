/**
 * @Author xlyu
 * @Date 2019/3/4 0004
 * @Description
 */
package homeworkday02;

import java.util.Scanner;

/**
 * @program: nycode01
 * @description: 收银程序
 * @author: xlyu
 * @create: 2019-03-04 19:28
 **/
public class CashRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the price($)");//单价
        int money = sc.nextInt();
        System.out.println("please input the number($)");//数量
        int number = sc.nextInt();
        System.out.println("Amount receivable($)");//应收金额
        System.out.println(money * number);
        System.out.println("Payment amount($)");//实际付款
        int pay = sc.nextInt();
        System.out.println("Give change($)");//找零
        System.out.println(pay - money * number);//找零
    }
}
