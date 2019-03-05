/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description: 收银程序V1.0
 * @author: xlyu
 * @create: 2019-03-05 16:05
 **/
public class CashierTestV01 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Please input the price($)");//单价
        double money = sc.nextDouble();
        System.out.println("please input the number($)");//数量
        double number = sc.nextDouble();
        System.out.println("Amount receivable($)");//应收金额
        System.out.println(money*number);
        System.out.println("Payment amount($)");//实际付款
        double pay = sc.nextDouble();
        System.out.println("Give change($)");// 找零
        System.out.println(pay-money*number);//找零

    }
}
