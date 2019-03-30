/**
 * @Author xlyu
 * @Date 2019/3/30
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaHomework
 * @description: ArrayListMethods测试
 * @author: xlyu
 * @create: 2019-03-30 16:05
 **/
public class ArrayListMethodsTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);//[a, b, a, b, a]

        /*add(int index,Object obj)——在指定位置增加元素*/
        list.add(2, "c");
        System.out.println(list);//[a, b, c, a, b, a]

        /*remove(int index)——移除指定位置的元素*/
        list.remove(2);
        System.out.println(list);//[a, b, a, b, a]

        /*get(int index),set(int index,E e)——g：获取对应位置的元素，范围类型是泛型。s:重设对应位置的元素*/
        list.set(2, "A");
        String str = list.get(2);
        System.out.println(list);//[a, b, A, b, a]
        System.out.println(str);//A

        /*indexOf(Object o),lastIndexOf(Object o)——返回对应o出现的位置*/
        int index = list.indexOf("A");
        System.out.println(index);//2
        int lastIndex = list.lastIndexOf("a");
        System.out.println(lastIndex);//4
    }
}
