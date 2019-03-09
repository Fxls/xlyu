/**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */
package book.book01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: document3.6
 * @description: 随机生一个数组，用户输入一个数字，如果在数组内则成功，不在则提示
 * @author: xlyu
 * @create: 2019-03-07 14:41
 **/
public class ArrJudge {
    public static void main(String[] args) {
        int length = (int) (Math.random() * 20 + 1);
        int[] arr = new int[length];
        System.out.println("please input a number!");
        Scanner scanner = new Scanner(System.in);
        int inpiut = scanner.nextInt();
        scanner.close();
        //设计boolean类型变量，判断数字是否与数组中的匹配（原理为遍历赋值，开关语句）
        boolean boo = true;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
            if (arr[i] == inpiut) {
                System.out.println("yes! Addres is arr" + "[" + i + "]!");
                boo = false;
            }
        }
        if (boo) {
            System.out.println("wrong");
        }
        System.out.println(Arrays.toString(arr));
    }
}
