/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description: 计算个人所得税
 * *扣除数=3500￥
 * * 应纳税额=（工资-扣除数）*税率-速算扣除数
 * * 全月应纳税额=工资-扣除数
 * *<=1500           3%      0
 * * 1500~4500       10%     105
 * * 4500~9000       20%     555
 * * 9000~35000      25%     1005
 * * 35000~55000     30%     2755
 * * 55000~80000     35%     5505
 * * >80000         45%     13505
 * @author: xlyu
 * @create: 2019-03-05 16:51
 **/
public class TaxTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的工资￥：");
        double salary = scanner.nextDouble();
        scanner.close();
        double deduction = 3500.00;
        double month = salary - deduction;
        if (month <= 1500.00) {
            System.out.println("您的个人所得税￥" + (month * 0.03 - 0.00));
        } else if (month <= 4500.00) {
            System.out.println("您的个人所得税￥" + (month * 0.10 - 105.00));
        } else if (month <= 9000.00) {
            System.out.println("您的个人所得税￥" + (month * 0.20 - 555.00));
        } else if (month <= 35000.00) {
            System.out.println("您的个人所得税￥" + (month * 0.25 - 1005.00));
        } else if (month <= 55000.00) {
            System.out.println("您的个人所得税￥" + (month * 0.30 - 2755.00));
        } else if (month <= 80000.00) {
            System.out.println("您的个人所得税￥" + (month * 0.35 - 5505.00));
        } else {
            System.out.println("您的个人所得税￥" + (month * 0.45 - 13505.00));
        }
    }
}
