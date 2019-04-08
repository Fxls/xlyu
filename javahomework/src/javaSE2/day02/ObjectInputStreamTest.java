/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @program: javaHomework
 * @description: 对象输入流
 * @author: xlyu
 * @create: 2019-04-06 11:35
 **/
public class ObjectInputStreamTest {

    @Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("demo/oos_test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Emp emp1 = (Emp) ois.readObject();
        System.out.println(emp1);//Emp{name='black', age=55, salary=1000.0}
        ois.close();
    }
}
