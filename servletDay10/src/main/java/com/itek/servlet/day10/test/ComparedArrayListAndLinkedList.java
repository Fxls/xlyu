/**
 * @Author xlyu
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servlet.day10.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: servletDay10
 * @description:
 * @author: xlyu
 * @create: 2019-06-04 18:09
 **/
public class ComparedArrayListAndLinkedList {
    static List<Integer> array = new ArrayList<>();
    static List<Integer> linked = new LinkedList<>();

    public static void main(String[] args) {
        //往不同的数据结构中添加数据
        for (int i = 0; i < 10000; i++) {
            array.add(i);
            linked.add(i);
        }

        //访问时间比较
        System.out.println("array time:" + getTime(array));
        System.out.println("linked time:"+getTime(linked));
        //插入时间比较
        System.out.println("array insert time:"+insertTime(array));
        System.out.println("linked insert time:"+insertTime(linked));
    }

    private static long getTime(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {

            //binarySearch() 方法是一种查找元素的方法
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }

        }
        return System.currentTimeMillis() - start;
    }

    private static long insertTime(List<Integer> list){
        /*
         * 插入的数据量和插入的位置是决定两者性能的主要方面，
         * 我们可以通过修改这两个数据，来测试两者的性能
         */
        long num = 10000; //表示要插入的数据量
        int index = 5000; //表示从哪个位置插入
        long time=System.currentTimeMillis();
        for(int i = 1; i < num; i++){
            list.add(index, i);
        }
        return System.currentTimeMillis()-time;

    }

    /**
     * arrayList：动态数组
     * linkedList：双向链表
     */


}

