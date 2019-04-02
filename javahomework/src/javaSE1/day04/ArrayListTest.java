/**
 * @Author xlyu
 * @Date 2019/4/1
 * @Description
 */
package javaSE1.day04;

import org.junit.Test;

import java.util.*;

/**
 * @program: javaHomework
 * @description: ArrayList测试
 * @author: xlyu
 * @create: 2019-04-01 18:43
 **/
public class ArrayListTest {

    @Test
    /**
     * addAll和containsAll的测试
     */
    public void test() {

        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        System.out.println(list);//[1.0, 2.0, 3.0]

        List<Double> list2 = new ArrayList<>();
        list2.add(1.0);
        list2.add(3.0);
        list2.add(2.0);
        System.out.println(list2);//[1.0, 3.0, 2.0]

        System.out.println(list.containsAll(list2));//true

        list.addAll(list2);
        System.out.println(list);//[1.0, 2.0, 3.0, 1.0, 3.0, 2.0]
    }

    @Test
    /**
     * 迭代器的一些使用
     */
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("床");
        list.add("前");
        list.add("明");
        list.add("月");
        list.add("光");
        list.add("光");
        Iterator<String> iterator = list.iterator();//[床, 前, 明, 月, 光, 光]
        System.out.println(list);
        while (iterator.hasNext()) {
            if ("光".equals(iterator.next())) {
                iterator.remove();//[床, 前, 明, 月]
            }
        }
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        Iterator<Integer> iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
            Integer integer = iterator1.next();
            System.out.print(integer);//12345
        }
    }

    @Test
    /**
     * 增强for循环
     */
    public void test3() {
        Integer[] arr = new Integer[5];
        for (Integer integer : arr) {
            integer = 10;
            System.out.print(integer + "\t");//10	10	10	10	10
        }
        System.out.println();

        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("L");
        list.add("O");
        list.add("S");
        list.add("E");
        for (String string : list) {
            System.out.print(string + "\t");//C  L	O	S	E
        }
        System.out.println();

        /*和上面等价*/
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.print(string + "\t");//C  L	O	S	E
        }
    }

    @Test
    /**
     * sublist的使用，get，set,add,remove的使用
     */
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "-");
        System.out.println(list);//[A, -, B, C, D, E]
        List<String> list2 = list.subList(0, 3);
        /*前包后不包*/
        System.out.println(list2);//[A, -, B]
        list.set(0, "a");
        System.out.println(list.get(0));//a
        list.remove("a");
        list.remove(1);
        System.out.println(list);//[-, C, D, E]
    }

    @Test
    /**
     * 数组和List之间的转换
     */
    public void test5() {
        /*List转数组*/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] strArr = list.toArray(new String[4]);
        System.out.println(Arrays.toString(strArr));//[1, 2, 3, null]

        /*数组转List*/
        String[] strArr2 = {"1", "2", "3"};
        /*此时list2中的元素不能操作*/
        List<String> list2 = Arrays.asList(strArr2);
        System.out.println(list2);//[1, 2, 3]
    }

    @Test
    /**
     * List排序
     */
    public void test6() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);

        /*用List自带的sort完成排序*/
        list.sort(Integer::compareTo);
        System.out.println(list);

        /*使用Collections.sort方法完成排序*/
        Collections.sort(list);
        System.out.println(list);

    }
}
