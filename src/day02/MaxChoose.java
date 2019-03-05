/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day02;

import java.util.Scanner;

/**
 * @program: day02.code
 * @description:  输出两个int数中的最大值
 * @author: xlyu
 * @create: 2019-03-05 16:37
 **/
public class MaxChoose {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入两个整数a，b");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        if (a>b){
            System.out.println(a);
        }
        if (a<b){
            System.out.println(b);
        }
        if (a==b){
            System.out.println("两数相等！");
        }
    }
}
