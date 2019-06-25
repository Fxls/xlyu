/**
 * @Author xlyu
 * @Date 2019/4/17
 * @Description
 */
package javaSE2.day07;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @program: javaHomework
 * @description: 服务端
 * @author: xlyu
 * @create: 2019-04-17 16:05
 **/
public class Server {

    public static void main(String[] args) throws IOException, DocumentException {
        ServerSocket server = new ServerSocket(8888);

        Socket client = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String read = null;
        FileOutputStream fos = new FileOutputStream("E:\\soft\\git\\xlyu\\javaHomework\\src\\javaSE2\\day07\\EmpCopy.xml");

        PrintWriter pw = new PrintWriter(fos, true);
        while ((read = br.readLine()) != null) {
//            sb.append(read);
            pw.println(read);

        }








        SAXReader reader = new SAXReader();
        Document doc = reader.read("E:\\soft\\git\\xlyu\\javaHomework\\src\\javaSE2\\day07\\EmpCopy.xml");
        /**
         * 解析
         */
        System.out.println("根元素" + doc.getRootElement().getName());//根元素emp
        List<Element> list = doc.getRootElement().elements();
        for (Element element : list) {
            System.out.println(element.getName() + ":" + element.getStringValue());
        }
        /**
         * 打印结果
         *  根元素emp
         * emp1:        马云        1000        45
         * emp2:        化腾        500000        35
         * emp3:        强东        120000        40
         *
         */
    }
}
