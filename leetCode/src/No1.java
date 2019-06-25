/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 **/

/**
 * @program: leetCode
 * @description: 两数之和
 * @author: xlyu
 * @create: 2019-06-13 10:56
 **/

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 
 * 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 来源：力扣（LeetCode）
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 */
public class No1 {
    public static void main(String[] args) {
        int[] arr = {5,5,5,11};
        int target = 10;
        int[] get = twoSum(arr, target);
        System.out.println(Arrays.toString(get));

    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i] && j != i) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
