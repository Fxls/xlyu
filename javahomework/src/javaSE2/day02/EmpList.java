/**
 * @Author xlyu
 * @Date 2019/4/6
 * @Description
 */
package javaSE2.day02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaHomework
 * @description: 第五题
 * @author: xlyu
 * @create: 2019-04-06 12:54
 **/
public class EmpList implements Serializable {
    public static final long serialVersionUID = 123l;


    public static void main(String[] args) throws Exception {

        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("zs", 20, 100.0));
        empList.add(new Emp("ls", 25, 150.0));
        empList.add(new Emp("mz", 18, 70.0));

        /*序列化（对象->字节）*/
        FileOutputStream fos = new FileOutputStream("demo/emplist.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(empList);
        oos.close();

        /*反序列化（字节->对象）*/
        FileInputStream fis = new FileInputStream("demo/emplist.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Emp> empList1 = (List<Emp>) ois.readObject();
        System.out.println(empList1);
        ois.close();
    }
}
