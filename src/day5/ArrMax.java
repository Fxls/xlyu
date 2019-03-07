/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package day5;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: homeworkday04
 * @description: 选出数组中最大的元素
 * @author: xlyu
 * @create: 2019-03-06 16:22
 **/
public class ArrMax {

    public static void main(String[] args) {
        int arr[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);

        }
        System.out.println("该数组为：" + Arrays.toString(arr));
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("数组中最大的数为：" + max);

    }
}
