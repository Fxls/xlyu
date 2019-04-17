/**
 * @Author xlyu
 * @Date 2019/4/17
 * @Description
 */
package javaSE2.day07;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @program: javaHomework
 * @description: xml读取
 * @author: xlyu
 * @create: 2019-04-17 14:31
 **/
public class ReadXml {
    public static void main(String[] args) throws Exception {

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/javaSE2/day07/xmlTest.xml"));
        Element root = document.getRootElement();
        //获取根元素
        System.out.println(root);
        /**
         * org.dom4j.tree.DefaultElement@7ba4f24f [Element: <user attributes: [org.dom4j.tree.DefaultAttribute@3b9a45b3 [Attribute: name id value "userId"]]/>]
         */

        //获取root下的名为ds元素
        Element e = root.element("ds");
        System.out.println(e);

        List<String> list = e.elements();
        System.out.println(list);

        //获取元素名
        String name = root.getName();
        System.out.println(name);
        //获取text
        String txt = root.getTextTrim();
        System.out.println(txt);
        //获取属性
        Attribute a1 = root.attribute(0);
        Attribute a2  = e.attribute("name");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.getName()+","+a1.getValue());
        System.out.println(a2.getName()+","+a2.getValue());
    }
}
