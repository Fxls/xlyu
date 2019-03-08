/**
 * @Author xlyu
 * @Date 2019/3/6 0006
 * @Description
 */
package basic.day05;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: homeworkday04
 * @description: 查询数组最小值，并扩容一个新数组，将查询值放到新数组的最前面
 * @author: xlyu
 * @create: 2019-03-06 22:26
 **/
public class ArrMine {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("该数组为：" + Arrays.toString(arr));
        int mine = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (mine > arr[i]) {
                mine = arr[i];
            }
        }
        System.out.println("该数组中小的值：" + mine);
        int arr1[] = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr1, 1, 10);
        arr1[0] = mine;
        System.out.println("新数组为：" + Arrays.toString(arr1));
    }

}
