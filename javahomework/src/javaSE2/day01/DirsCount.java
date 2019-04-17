/**
 * @Author xlyu
 * @Date 2019/4/4
 * @Description
 */
package javaSE2.day01;

import java.io.File;

/**
 * @program: javaHomework
 * @description: 打印输出一个文件夹中所有文件大小的总和（包含子孙级文件）
 * @author: xlyu
 * @create: 2019-04-04 10:30
 **/
public class DirsCount {
    private static long length = 0;

    public static void main(String[] args) {
        File file = new File("E:\\soft\\git\\xlyu\\javahomework");
        count(file);
        System.out.println("javahomework大小为：" + length);//53962034
    }

    /**
     * 递归思想
     * @param src
     */
    private static void count(File src) {
        if (null != src && src.exists()) {
            if (src.isFile()) {
                length += src.length();
            } else {
                for (File f : src.listFiles()) {
                    count(f);
                }
            }
        }
    }
}
