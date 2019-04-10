/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @program: javaHomework
 * @description: 试图连接外地服务器
 * @author: xlyu
 * @create: 2019-04-10 18:23
 **/
public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.1.20", 8800);
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println("successful Connection");
        client.close();
    }
}
