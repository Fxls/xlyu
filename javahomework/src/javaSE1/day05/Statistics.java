/**
 * @Author xlyu
 * @Date 2019/4/2
 * @Description
 */
package javaSE1.day05;

import java.util.*;

/**
 * @program: javaHomework
 * @description: 统计字符出现个数
 * @author: xlyu
 * @create: 2019-04-02 19:43
 **/
public class Statistics {
    private static String string = "good good study, day day up";

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("g", numOfString("g"));
        map.put("o", numOfString("o"));
        map.put("d", numOfString("d"));
        map.put("u", numOfString("u"));
        map.put("s", numOfString("s"));
        map.put("t", numOfString("t"));
        map.put("y", numOfString("y"));
        map.put("p", numOfString("p"));
        map.put("a", numOfString("a"));

        System.out.println(map);//{p=1, a=2, s=1, d=5, t=1, u=2, g=2, y=3, o=4}

        /*使用keySet遍历*/
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print(key + "\t");//p	a	s	d	t	u	g	y	o
        }

        System.out.println();

        /*使用Entry遍历键值对*/
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");//p:1	a:2	s:1	d:5	t:1	u:2	g:2	y:3	o:4
        }
    }

    /**
     * @return
     * @Param
     * @description TODO 计算指定字符出现的个数方法
     * @date 2019/4/3 19:10
     */
    private static int numOfString(String str) {
        int length = string.length();
        String strNew = string.replaceAll(str, "");
        int lengthNewStr = strNew.length();
        int repeat = length - lengthNewStr;
        return repeat;
    }
}
