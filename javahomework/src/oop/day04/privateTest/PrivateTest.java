/**
 * @Author xlyu
 * @Date 2019/3/15 0015
 * @Description
 */
package oop.day04.privateTest;

/**
 * @program: javaHomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-15 09:49
 **/
public class PrivateTest {
    private String string = "123";
    private String string2 = "123";

    public void Sum() {
        String sum;
        //这里可以调用，因为调用的范围在本类中
        sum = string + string2;
    }
}
