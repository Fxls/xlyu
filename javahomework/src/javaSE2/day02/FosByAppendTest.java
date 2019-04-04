/**
 * @Author xlyu
 * @Date 2019/4/4
 * @Description
 */
package javaSE2.day02;

import org.junit.Test;


import java.io.FileOutputStream;

/**
 * @program: javaHomework
 * @description:
 * @author: xlyu
 * @create: 2019-04-04 11:31
 **/
public class FosByAppendTest {
    @Test
    public void test() throws Exception {
        FileOutputStream fos = new FileOutputStream("E:\\soft\\git\\xlyu\\javahomework\\demo\\文本测试.txt");
        fos.write("write测试成功".getBytes());
        fos.close();
    }
}
