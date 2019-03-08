/**
 * @Author xlyu
 * @Date 2019/3/8 0008
 * @Description
 */
package basic.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: javahomework
 * @description: 封装一个方法generateArray，该方法实现生成指定长度的int数组
 * 该数组为0到指定范围内的随机数，并将该数组返回
 * @author: xlyu
 * @create: 2019-03-08 15:31
 **/
public class GenerateArray {
    //声明一个方法，length为生成数组的长度，range为数组内元素的赋值范围
    public static int[] arr(int length, int range) {
        //定义数组长度为x
        int x = length;
        int[] arr = new int[x];
        //遍历数组随机赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (range + 1));
        }
        //return 语句，返回的类型是int[]
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int x = scanner.nextInt();
        System.out.println("请输入数组中元素的取值范围：0~");
        int y = scanner.nextInt();
        int[] arr = arr(x, y);
        System.out.println(Arrays.toString(arr));
    }

}

