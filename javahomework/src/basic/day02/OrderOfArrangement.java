/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package basic.day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description:  编写三个数值的排序程序
 * @author: xlyu
 * @create: 2019-03-05 16:43
 **/
public class OrderOfArrangement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入三个数");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        if (a <= b && b <= c) {
            System.out.println(a + " " + b + " " + c);
        } else if (a <= c && c <= b) {
            System.out.println(a + " " + c + " " + b);
        } else if (b <= a && a <= c) {
            System.out.println(b + " " + a + " " + c);
        } else if (b <= c && c <= a) {
            System.out.println(b + " " + c + " " + a);
        } else if (c <= a && a <= b) {
            System.out.println(c + " " + a + " " + b);
        } else {
            System.out.println(c + " " + b + " " + a);
        }
    }
}
