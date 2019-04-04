/**
 * @Author xlyu
 * @Date 2019/4/4
 * @Description
 */
package javaSE2.day01;

import java.io.File;

/**
 * @program: javaHomework
 * @description: 打印一个目录下的所有文件和目录（名），以及目录中的目录和文件，直到全部打印出文件名为止
 * @author: xlyu
 * @create: 2019-04-04 10:02
 **/
public class PrintAllFileAndDir {
    public static void main(String[] args) {
        File file = new File("E:\\soft\\git\\xlyu\\javahomework\\src\\javaSE1");
        printName(file);
    }

    private static void printName(File src) {
        /*使用递归方法来打印所有文件和目录*/
        System.out.println(src.getName());
        if (null == src || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for (File f : src.listFiles()) {
                printName(f);
            }
        }

    }
}
