/**
 * @Author xlyu
 * @Date 2019/4/3
 * @Description
 */
package javaSE2.day01;

import java.io.File;

/**
 * @program: javaHomework
 * @description: 第一题
 * @author: xlyu
 * @create: 2019-04-03 20:00
 **/
public class Task01 {
    public static void main(String[] args) {

        /*输出.jar,使用listFile和FileFilter过滤器实现*/
        File file = new File("E:\\soft");
        File[] list = file.listFiles(pathname -> pathname.getName().endsWith(".jar"));
        for (File f : list) {
            System.out.println(f);//E:\soft\commons-lang-2.1.jar    E:\soft\junit-4.7.jar
        }
    }
}
