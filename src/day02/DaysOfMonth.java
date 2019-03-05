/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description:  输入年份月份，输出当月天数
 * @author: xlyu
 * @create: 2019-03-05 16:57
 **/
public class DaysOfMonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份（eg：2019）");
        int year = scanner.nextInt();
        System.out.println("请输入月份（eg：6）");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(year + "年" + month + "月份有：31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(year + "年" + month + "月份有：30天");
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    System.out.println(year + "年" + month + "月份有：29天");
                } else {
                    System.out.println(year + "年" + month + "月份有：28天");
                }
                break;
        }
    }
}
