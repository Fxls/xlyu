/**
 * @Author xlyu
 * @Date 2019/4/2
 * @Description
 */
package javaSE1.day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: javaHomework
 * @description: Map测试（键值对）
 * @author: xlyu
 * @create: 2019-04-02 10:55
 **/
public class MapTest {
    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        /*put方法添加元素*/
        map.put("1", "!");
        map.put("2", "@");
        map.put("3", "#");
        map.put("4", "~");
        System.out.println(map);//{1=!, 2=@, 3=#, 4=~}

        /*不能添加key相同的元素，如果添加，则覆盖（equals）*/
        map.put("4", "$");
        System.out.println(map);//{1=!, 2=@, 3=#, 4=$}

        /*get方法获取对应键的值*/
        System.out.println(map.get("1"));//!

        /*isEmpty:检测是否为空*/
        System.out.println(map.isEmpty());//false

        /*size:计算键值对的个数*/
        System.out.println(map.size());//4

        /*containsKey:是否有相同键的元素*/
        System.out.println(map.containsKey("1"));//true

        /*containsValue:是否有对应值得元素*/
        System.out.println(map.containsValue("&"));//false

        /*putAll：加入另一个Map的全部元素*/
        Map<String, String> map1 = new HashMap<>();
        map1.put("5", "%");
        map1.put("6", "^");
        map1.put("7", "&");

        /*key,value要一致*/
        map1.putAll(map);
        System.out.println(map1);//{1=!, 2=@, 3=#, 4=$, 5=%, 6=^, 7=&}

        /*keySet:遍历Map中的key*/
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);//key的值
            System.out.println(keySet);//[1, 2, 3, 4]
        }

        /*entrySet:遍历Map中的键值对*/
        Set<Map.Entry<String, String>> entrySet = map1.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());//1:! 2:@.......
        }
    }
}
