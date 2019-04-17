/**
 * @Author xlyu
 * @Date 2019/4/17
 * @Description
 */
package javaSE2.day07;

import org.dom4j.DocumentException;

import java.io.*;
import java.net.Socket;


/**
 * @program: javaHomework
 * @description: 客户端
 * @author: xlyu
 * @create: 2019-04-17 16:04
 **/
public class Client {
    public static void main(String[] args) throws IOException, DocumentException {
        Socket client = new Socket("127.0.0.1", 8888);
        FileInputStream fis = new FileInputStream("E:\\soft\\git\\xlyu\\javaHomework\\src\\javaSE2\\day07\\Emp.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String read = null;
        StringBuilder sb = new StringBuilder();
        while ((read = br.readLine()) != null) {
            sb = sb.append(read);
        }
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        String send = sb.toString();
        pw.println(send);
        client.close();
    }
}
