/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package basic.day04;

import java.util.Scanner;

/**
 * @program: homeworkday04
 * @description: 1+1/2+1/3+...+1/n=？
 * @author: xlyu
 * @create: 2019-03-05 19:08
 **/
public class SumOfSequences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input numeber!");
        int input = scanner.nextInt();//输入数据
        double sum = 1;//声明总和
        System.out.print(1);
        for (int i = 2; i >= 2; i++) {//设计一个死循环，当输入数据和循环条件相等时退出循环
            double n;
            n = 1.0 / i;//运算表达式
            sum = sum + n;//求和表达式
            System.out.print("+" + 1 + "/" + i);
            if (i == input) {
                break;
            }

        }

        System.out.println("=" + sum);
    }
}

