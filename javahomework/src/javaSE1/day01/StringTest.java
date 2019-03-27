/**
 * @Author xlyu
 * @Date 2019/3/25 0025
 * @Description
 */
package javaSE1.day01;

import org.junit.Test;

/**
 * @program: javahomework
 * @description: 字符串测试
 * @author: xlyu
 * @create: 2019-03-25 14:35
 **/


public class StringTest {
    @Test
    public void test() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "hel" + "lo";
        String str4 = "hel" + new String("lo");
        String str5 = new String("hello");
        String str6 = str5.intern();
        String str7 = "h";
        String str8 = "ello";
        String str9 = str7 + str8;

        //true:指向常量池中的“hello”
        System.out.println(str1 == str2);

        //true:只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
        System.out.println(str1 == str3);

        //false:对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中。
        System.out.println(str1 == str4);

        //false:str7指向常量池中的h，str8指向·常量池·中的ello，str9指向·堆·中的str7+str8
        System.out.println(str1 == str9);

        //false:都在堆中，但不是一个地址，他们是不同的
        System.out.println(str4 == str5);

        /*true:intern方法将hello添加到常量池中，并返回其在常量池中的地址，因为常量池中已经有了hello字符串，
         所以intern方法直接返回地址；而s1在编译器就已经指向常量池了，因此s1和s6指向同一地址*/
        System.out.println(str1 == str6);
    }

}
