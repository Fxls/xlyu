/**
 * @Author xlyu
 * @Date 2019/4/4
 * @Description
 */
package javaSE2.day01;

import java.io.File;

/**
 * @program: javaHomework
 * @description: 面向对象设计：统计文件夹中所含文件个数，所含文件夹个数，所有文件大小等
 * @author: xlyu
 * @create: 2019-04-04 10:46
 **/
public class DirsCountOOP {
    //文件夹中所有文件大小
    private long length;
    //所有文件的个数
    private int fileSize;
    //所有子文件夹的个数（不包括此文件夹本身）
    private int dirSize = -1;
    //路径名
    private String path;
    //源File
    private File src;


    /**
     * @return
     * @Param
     * @description TODO 重载构造
     * @date 2019/4/4 11:05
     */
    public DirsCountOOP(String path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    /**
     * @return
     * @Param
     * @description TODO Getter length
     * @date 2019/4/4 11:06
     */
    public long getLength() {
        return length;
    }

    /**
     * @return
     * @Param
     * @description TODO Getter fileSize
     * @date 2019/4/4 11:06
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @return
     * @Param
     * @description TODO Getter dirSize
     * @date 2019/4/4 11:06
     */
    public int getDirSize() {
        return dirSize;
    }

    /**
     * @Param
     * @description TODO count方法，方法中统计了 1、此文件夹中所有文件的大小总和 2、此文件夹中文件个数 3、此文件夹中文件夹个数为
     * @date 2019/4/4 11:07
     * @return
     */
    private void count(File src) {
        if (null != src && src.exists()) {
            if (src.isFile()) {
                //是文件，个数+1
                this.fileSize++;
                length += src.length();
            } else {
                //是文件夹，个数+1
                this.dirSize++;
                for (File f : src.listFiles()) {
                    count(f);
                }
            }
        }
    }


    public static void main(String[] args) {
        DirsCountOOP d = new DirsCountOOP("E:/soft/git/xlyu/javahomework");
        System.out.println("此文件夹中所有文件的大小总和为：" + d.getLength());//53966892
        System.out.println("此文件夹中文件个数为" + d.getFileSize());//353
        System.out.println("此文件夹中文件夹个数为" + d.getDirSize());//78
    }

}
