/**
 * @Author xlyu
 * @Date 2019/4/17
 * @Description
 */
package javaSE2.day07;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;

/**
 * @program: javaHomework
 * @description: 输出一个自定义的Emp类型的xml文本
 * @author: xlyu
 * @create: 2019-04-17 15:27
 **/
public class WriteXml {
    public static void main(String[] args) throws Exception {
        //创建需要输出的xml对象
        Document doc = DocumentHelper.createDocument();

        Element root = doc.addElement("emp");

        Element emp1 = root.addElement("emp1");
        emp1.addAttribute("age", "45");
        emp1.addAttribute("salary", "1000");
        emp1.addAttribute("name", "马云");
        Element name = emp1.addElement(emp1.attribute(2).getName());
        name.addText(emp1.attribute(2).getValue());
        Element salary = emp1.addElement(emp1.attribute(1).getName());
        salary.addText(emp1.attribute(1).getValue());
        Element age = emp1.addElement(emp1.attribute(0).getName());
        age.addText(emp1.attribute(0).getValue());

        Element emp2 = root.addElement("emp2");
        emp2.addAttribute("age", "35");
        emp2.addAttribute("salary", "500000");
        emp2.addAttribute("name", "化腾");
        Element name2 = emp2.addElement(emp2.attribute(2).getName());
        name2.addText(emp2.attribute(2).getValue());
        Element salary2 = emp2.addElement(emp2.attribute(1).getName());
        salary2.addText(emp2.attribute(1).getValue());
        Element age2 = emp2.addElement(emp2.attribute(0).getName());
        age2.addText(emp2.attribute(0).getValue());

        Element emp3 = root.addElement("emp3");
        emp3.addAttribute("age", "40");
        emp3.addAttribute("salary", "120000");
        emp3.addAttribute("name", "强东");
        Element name3 = emp3.addElement(emp3.attribute(2).getName());
        name3.addText(emp3.attribute(2).getValue());
        Element salary3 = emp3.addElement(emp3.attribute(1).getName());
        salary3.addText(emp3.attribute(1).getValue());
        Element age3 = emp3.addElement(emp3.attribute(0).getName());
        age3.addText(emp3.attribute(0).getValue());


        XMLWriter writer = new XMLWriter();
        FileOutputStream fos = new FileOutputStream("src/javaSE2/day07/Emp.xml");
        writer.setOutputStream(fos);
        writer.write(doc);
        writer.close();
    }
}
