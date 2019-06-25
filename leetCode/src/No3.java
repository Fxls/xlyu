/**
 * @Author xlyu
 * @Date 2019/6/14
 * @Description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @description: 杨辉三角
 * @author: xlyu
 * @create: 2019-06-14 19:37
 **/
public class No3 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);
        System.out.println(list);
    }

    private static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //p1:零行
        if (numRows == 0) {
            return list;
        }

        //集中集
        list.add(new ArrayList<>());
        //获取集中集添加第一行元素“1”.
        list.get(0).add(1);
        //迭代算法（遍历）
        for (int count = 1; count < numRows; count++) {
            //当前行
            List<Integer> thisRow = new ArrayList<>();
            //上一行
            List<Integer> preRow = list.get(count-1);
            //给当前行的一个数赋值“1”
            thisRow.add(1);
            //TODO 添加中间数
            for (int j = 1; j < count; j++) {
                thisRow.add(preRow.get(j - 1) + preRow.get(j));
            }

            //给当前行的最后一个数赋值“1”
            thisRow.add(1);
            //添加集中集
            list.add(thisRow);
        }
        return list;

    }
}
