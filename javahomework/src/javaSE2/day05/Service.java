/**
 * @Author xlyu
 * @Date 2019/4/10
 * @Description
 */
package javaSE2.day05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: javaHomework
 * @description: 服务端
 * @author: xlyu
 * @create: 2019-04-10 14:56
 **/
public class Service {
    public static void main(String[] args) throws IOException {
        //1、创建服务端对象
        ServerSocket service = new ServerSocket(8111);

        //2、监听服务端端口，是否有来自客户端的请求
        Socket client = service.accept();

        //输入操作
        InputStream is = client.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        //读操作
        while (true) {
            String str = br.readLine();
            if (str==null) {
                break;
            }else{
                System.out.println(str);
            }
        }

        System.out.println("end");

    }
}
