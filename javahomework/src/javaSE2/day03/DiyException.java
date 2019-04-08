/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: javaHomework
 * @description: 自定义异常类
 * @author: xlyu
 * @create: 2019-04-08 15:54
 **/
public class DiyException extends RuntimeException {
    public DiyException() {

    }

    public DiyException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("7/8/9");
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new DiyException("非法路径！");
        }
    }

}
