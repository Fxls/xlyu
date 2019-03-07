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
 * @description: 在ArrMax的基础上对数组进行扩容，并将Max值放在扩容数组的最后一位的
 * @author: xlyu
 * @create: 2019-03-06 18:47
 **/
public class ArrMax2 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("该数组为：" + Arrays.toString(arr));
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("数组中的最大元素为：" + max);
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr [arr.length-1]=max;
        System.out.println("新数组为："+Arrays.toString(arr));
    }
}
