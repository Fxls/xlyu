/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package basic.day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description: if else  实现闰年的判断
 * @author: xlyu
 * @create: 2019-03-05 16:48
 **/
public class LeapYearTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份(eg:2019)：");
        int year = scanner.nextInt();
        scanner.close();
        if ((year%4==0&&year%100!=0)||year%400==0){
            System.out.println(year+"年是闰年！");
        }else {
            System.out.println(year+"年是平年！");
        }
    }
}
