/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @program: javaHomework
 * @description: 对象输出流
 * @author: xlyu
 * @create: 2019-04-06 11:21
 **/
public class ObjectOutputStreamTest {

    /**
     * @throws Exception
     */
    @Test
    public void testOOS() throws Exception {
        Emp emp1 = new Emp("black", 55, 1000.0);
        FileOutputStream fos = new FileOutputStream("demo/oos_test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp1);
        oos.close();
    }
}
