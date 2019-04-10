/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * @program: javaHomework
 * @description: 客户端
 * @author: xlyu
 * @create: 2019-04-10 14:56
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        //1、建立客户端，请求服务器，（ip 和 端口）
        Socket client = new Socket("127.0.0.1", 8111);

        //2、连接成功可以进行后续操作
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println("Client");
        System.out.println(ld + "\t" + lt);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.next();
            pw.println(input);
            if ("退出".equals(input)) {
                break;
            }
        }

        client.close();
    }
}
