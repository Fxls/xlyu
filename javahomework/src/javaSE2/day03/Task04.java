/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: javaHomework
 * @description: 第四题
 * @author: xlyu
 * @create: 2019-04-08 17:25
 **/
public class Task04 {
    public void test() {
        try {
            FileOutputStream fos = new FileOutputStream("demo/SE2_Day03_Task04.txt");
            fos.write(1);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
