/**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */
package book.book01;

import java.util.Arrays;

/**
 * @program: document3.6
 * @description: 实现数扩容功能
 * @author: xlyu
 * @create: 2019-03-07 18:10
 **/
public class ArrExpand {
    public static void main(String[] args) {
        int leng = (int) (Math.random() * 10 + 1);
        int[] arr = new int[leng];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("扩展前的数组为：" + Arrays.toString(arr));
        arr = Arrays.copyOf(arr, arr.length + 3);
        System.out.println("扩展后的数组为：" + Arrays.toString(arr));
    }
}
