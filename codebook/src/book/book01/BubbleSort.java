package book.book01; /**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */

import java.util.Arrays;

/**
 * @program: document3.6
 * @description: 冒泡排序
 * @author: xlyu
 * @create: 2019-03-07 13:34
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int length = (int) (Math.random() * 20 + 1);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int x = (int) (Math.random() * 100 + 1);
            arr[i] = x;
        }
        System.out.println("该数组为：" + Arrays.toString(arr));
        System.out.println("数组中的元素个数为："+length);
        for (int i = 1; i < arr.length; i++) {
            for (int i2 = 1; i2 <= arr.length-i ; i2++) {
                if (arr[i2 - 1] > arr[i2]) {
                    int t = arr[i2 - 1];
                    arr[i2 - 1] = arr[i2];
                    arr[i2] = t;
                }
            }
        }
        System.out.println("新数组为：" + Arrays.toString(arr));

    }
}
