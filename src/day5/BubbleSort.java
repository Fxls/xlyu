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
 * @description: 冒泡排序
 * @author: xlyu
 * @create: 2019-03-06 19:43
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("数组为： " + Arrays.toString(arr));
        System.out.println("开始排序：");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            System.out.println("第" + (i + 1) + "遍的排序结果：" + Arrays.toString(arr));
        }
        System.out.println("冒泡排序结束！");
    }
}
