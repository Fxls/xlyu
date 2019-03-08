/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package basic.day05;

import java.util.Scanner;

/**
 * @program: homeworkday04
 * @description: 给定范围2~100，输出质数
 * @author: xlyu
 * @create: 2019-03-06 21:41
 **/
public class PrimeNumber {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入查找质数的范围：2~");
        int max = scanner.nextInt();
        scanner.close();
        //判断质数的方法：只需要判断2到根号N之间，是否有数能被自己整除即可
        int numOfPrime = 0;
        //外层for循环作用：在范围2~maxnei执行循环体
        for (int n = 2; n <= max; n++) {
            // 判断n是否是质数
            int m = (int) Math.sqrt(n);//开平发算法Math.sqrt();
            int i = 2;//开平方的初始值为2
            //for循环的嵌套，这里进行
            for (; i <= m; i++) {
                if (n % i == 0) {
                    break;
                }
            }
            if (i > m) {
                System.out.print(n + "\t");
                if (++numOfPrime % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println("\n共有" + numOfPrime + "个质数");

    }


}


