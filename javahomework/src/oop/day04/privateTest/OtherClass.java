/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package oop.day04.privateTest;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-15 11:02
 **/
public class OtherClass {
    public OtherClass() {
        PrivateTest p = new PrivateTest();
        //这两行代码错误，因为private修饰的成员只能在本类中调用
        /**p.string;
         p.string2;*/
    }
}
