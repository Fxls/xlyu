/**
 * @Author xlyu
 * @Date 2019/3/30
 * @Description
 */
package javaSE1.day03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: javaHomework
 * @description: CollectionMethods测试
 * @author: xlyu
 * @create: 2019-03-30 14:48
 **/
public class CollectionMethodsTest {
    @Test
    public void test() {

        /**Collection是一个接口，list和set是他的子接口，ArrayList是list的实现类，所以这个测试中的方法，都为Collection的方法
         * list和set同样适用*/
        Collection<String> c = new ArrayList<>();

        /*size判断该集合存储的内容*/
        int size = c.size();

        /*isEmpty判断该集合是否是空集*/
        boolean empty = c.isEmpty();
        System.out.println(size);//
        System.out.println(empty);//true
        System.out.println(c);//[]

        /*add——在集合中添加元素，添加元素要对应泛型*/
        c.add("i");
        c.add("love");
        c.add("u");
        System.out.println(c);//[i, love, u]

        /*remove方法是去除集合中元素指向的地址，而并不是抹去对象，也就是说，"i"和"u"这两个对象依然存在，只是集合中没有指向他们了而已*/
        c.remove("i");
        c.remove("u");
        System.out.println(c);//[love]

        /*toArray——返回一个包含此集合中所有元素的数组。*/
        Object obj = c.toArray();
        System.out.println(obj);//[Ljava.lang.Object;@68de145

        /*clear——清空集合，此时集合为空*/
        c.clear();
        System.out.println(c);//[]
    }

    @Test
    public void test2() {
        Collection<String> c = new ArrayList<>();
        Collection<String> c2 = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("1");
        c.add("2");
        c2.add("a");
        c2.add("b");
        c2.add("c");
        c2.add("4");
        c2.add("5");
        System.out.println(c);//[a, b, c, 1, 2]
        System.out.println(c2);//[a, b, c, 4, 5]
        /*containsAll用于判断一个集合是否包括另一个集合中的所有元素*/
        boolean result = c2.containsAll(c);
        System.out.println(result);//false

        /*addAll将一个容器中的所有元素添加到另一个容器中*/
        c2.addAll(c);
        System.out.println(c2);//[a, b, c, 4, 5, a, b, c, 1, 2]

        /*removeAll——移除本容器和另一个容器中都包含的元素*/
        c2.removeAll(c);
        System.out.println(c2);//[4, 5]

        /*retainAll——取本容器和另一容器都包含的元素，移除非交集元素（取交集）*/
        c2.add("a");
        c2.add("b");
        c2.add("c");
        c2.retainAll(c);
        System.out.println(c2);//[a, b, c],85-87行代码不加输出结果为[]也就是空集
    }
}
