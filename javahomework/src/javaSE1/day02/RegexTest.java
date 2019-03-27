/**
 * @Author xlyu
 * @Date 2019/3/26 0026
 * @Description
 */
package javaSE1.day02;

import org.junit.Test;

/**
 * @program: javahomework
 * @description: 正则表达式测试
 * @author: xlyu
 * @create: 2019-03-26 18:46
 **/
public class RegexTest {

    @Test
    public void test1() {
        String s1 = "[abc]";//abc中的任意一个
        String s2 = "[^abc]";//除了abc以外的字符
        String s3 = "[a-z]";//a~z的任意一个字符
        String s4 = "[a-zA-Z0-9]";//a~z||A~Z||0~9中的任意一个
        String s5 = "[a-z&&[^a-y]]";//z（a-z并且除了a-y，只能是z）
        String s6 = "[a-z||[^a-z]]";//任意一个字符（a-z或除了a-z的任意一个字符）
        System.out.println("ab".matches(s1));//false
        System.out.println("d".matches(s2));//true
        System.out.println("F".matches(s3));//false
        System.out.println("*".matches(s4));//false
        System.out.println("z".matches(s5));//true
        System.out.println("*".matches(s6));//true
    }

    @Test
    public void test2() {
        String s1 = "[abc]*";//0次或多次
        String s2 = "\\a";//
        System.out.println("aaa".matches(s1));
        System.out.println("a".matches(s2));
    }

    @Test
    public void test3() {

    }
}
