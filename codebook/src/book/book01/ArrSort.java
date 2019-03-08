/**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */
package book.book01;

import java.util.Arrays;

/**
 * @program: document3.6
 * @description: 实现随机数组的正序排列和逆序排列
 * @author: xlyu
 * @create: 2019-03-07 16:22
 **/
public class ArrSort {
    public static void main(String[] args) {
        //创建一个随机数组
        int length = (int) (Math.random() * 10 + 3);
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("该数组为：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int i2 = 1; i2 <= length - i; i2++) {
                if (arr[i2 - 1] > arr[i2]) {
                    int t = arr[i2 - 1];
                    arr[i2 - 1] = arr[i2];
                    arr[i2] = t;
                }
            }
        }
        System.out.println("正序排列：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int i2 = 1; i2 <= length - i; i2++) {
                if (arr[i2 - 1] < arr[i2]) {
                    int t = arr[i2 - 1];
                    arr[i2 - 1] = arr[i2];
                    arr[i2] = t;
                }
            }
        }
        System.out.println("逆序排列：" + Arrays.toString(arr));

    }
}