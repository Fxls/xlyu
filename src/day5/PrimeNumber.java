/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package day5;

import java.util.Random;
import java.util.Scanner;

/**
 * @program: homeworkday04
 * @description: 给定范围2~100，输出质数
 * @author: xlyu
 * @create: 2019-03-06 21:41
 **/
public class PrimeNumber {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入： "+"2~");
//        int a= scanner.nextInt();
//        int num;
//        boolean zhishu = false;
//        for (int i = 2; i < a; i++) {
//
//            if (num % i == 0) {
//                zhishu = false;
//                break;
//            }
//            zhishu = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入查找质数的范围：2~");
        int max = scanner.nextInt();
        scanner.close();
        int a = 0;
        for (int n = 2; n <= max; n++) {
            // 判断n是否是质数
            int m = (int) Math.sqrt(n);//开平方公式
            int i = 2;
            for (; i <= m; i++) {
                if (n % i == 0)
                    break;
            }
            if (i > m) {
                System.out.print(n + "\t");
                if (++a % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println("\n共有" + numOfPrime + "个质数");
    }


}


