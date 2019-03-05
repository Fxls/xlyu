/**
 * @Author xlyu
 * @Date 2019/3/5 0005
 * @Description
 */
package day04;

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
        int q = scanner.nextInt();
        double a = 1;
        double b = 1;
        System.out.print(1);
        for (int i = 2; i >= 2; i++) {

            b = b / i;
            a = a + b;
            System.out.print("+" + 1 + "/" + i);
            if (i == q) {
                break;
            }

        }

        System.out.println("=" + a);
    }
}
