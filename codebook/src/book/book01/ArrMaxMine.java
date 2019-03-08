/**
 * @Author xlyu
 * @Date 2019/3/7 0007
 * @Description
 */
package book.book01;

import java.util.Arrays;

/**
 * @program: document3.6
 * @description: 输出随机数组中的最大值和最小值
 * @author: xlyu
 * @create: 2019-03-07 15:45
 **/
public class ArrMaxMine {
    public static void main(String[] args) {
        //定义随机数组的长度
        int length = (int) (Math.random() * 20 + 1);
        int[] arr = new int[length];
        //定义随机数组中的随机元素（for）
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(arr));
        //筛选最大值max
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);
        //筛选最小值mine
        int mine = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (mine >= arr[i]) {
                mine = arr[i];
            }
        }
        System.out.println("最小值为：" + mine);
    }
}
