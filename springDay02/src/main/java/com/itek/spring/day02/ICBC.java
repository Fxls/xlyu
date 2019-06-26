/**
 * @Author xlyu
 * @Date 2019/6/26
 * @Description
 */
package com.itek.spring.day02;

/**
 * @program: springDay02
 * @description:
 * @author: xlyu
 * @create: 2019-06-26 09:24
 **/
public class ICBC {
    @Override
    public String toString() {
        return "ICBC{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
