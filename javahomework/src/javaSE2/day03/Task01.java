/**
 * @Author xlyu
 * @Date 2019/4/8
 * @Description
 */
package javaSE2.day03;

import java.io.*;

/**
 * @program: javaHomework
 * @description: 第一题
 * @author: xlyu
 * @create: 2019-04-08 16:08
 **/
public class Task01 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("demo/SE2Task01.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String str = null;
            String str2 = "";
            String str3 = "";
            while ((str = br.readLine()) != null) {
                str2 += str.trim() + "\n";
                str3 += str.trim();
            }
            PrintWriter pw = new PrintWriter("demo/SE2Task01.txt");
            pw.println(str2.trim());
            pw.println(str3);
            pw.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
