/**
 * @Author xlyu
 * @Date 2019/3/22 0022
 * @Description
 */
package zzzz;

/**
 * @program: javahomework
 * @description:
 * @author: xlyu
 * @create: 2019-03-22 15:40
 **/
public class Test2 extends Test {
    public void methodtwo() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        Test f = new Test2();
        ((Test2) f).methodtwo();
    }
}
