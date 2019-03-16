/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package oop.day04.privateTest.otherPack;

import oop.day04.privateTest.PrivateTest;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-15 10:59
 **/
public class Son extends PrivateTest {
    PrivateTest p = new PrivateTest();
    //private修饰的成分只能在本类调用
    /**p.string;*/
}
