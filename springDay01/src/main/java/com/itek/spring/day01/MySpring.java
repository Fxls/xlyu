/**
 * @Author xlyu
 * @Date 2019/6/25
 * @Description
 */
package com.itek.spring.day01;

import com.itek.spring.day01.module.Computer;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springDay01
 * @description:
 * @author: xlYu
 * @create: 2019-06-25 10:28
 **/
public class MySpring {
    /**
     * 存储单例bean
     */
    private Map<String, Object> singletonBeans = new HashMap<>();
    private Document doc;
    private Element root;

    /**
     * 初始化容器，加载配置文件
     */
    public MySpring(String config) {
        /**
         * 从classpath加载配置文件，返回类型是一个字节流
         */
        InputStream is = MySpring.class.getClassLoader().getResourceAsStream(config);
        SAXReader reader = new SAXReader();
        try {
            doc = reader.read(is);
            root = doc.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        String config = "test.xml";
        MySpring ms = new MySpring(config);
        Computer huawei = (Computer) ms.getBean("compu");
        System.out.println(huawei);
    }

    /**
     * 自定义getBean方法
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        /**
         * 判断bean对象是否已经被创建，如果创建直接返回该对象
         */
        if (singletonBeans.containsKey(beanId)) {
            return singletonBeans.get(beanId);
        }
        List<Element> beanEles = root.elements("bean");
        System.out.println(beanEles.size());
        /**
         * 遍历xml所有节点
         */
        for (Element beanEle : beanEles) {
            Attribute attr = beanEle.attribute("id");
            /**
             * attr判断空值与否
             */
            if (attr != null && attr.getValue().equals(beanId)) {
                Attribute attribute = beanEle.attribute("class");
                String className = attribute.getValue();
                /**
                 * java反射机制
                 */
                try {
                    /**
                     * 根据className动态生成对象
                     */
                    Class clazz = MySpring.class.getClassLoader().loadClass(className);
                    /**
                     * 调用无参构造
                     */
                    Constructor cons = clazz.getConstructor();
                    Object instance = cons.newInstance();
                    singletonBeans.put(beanId, instance);
                    return instance;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
