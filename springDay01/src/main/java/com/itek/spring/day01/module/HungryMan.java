/**
 * @Author xlyu
 * @Date 2019/6/24
 * @Description
 */
package com.itek.spring.day01.module;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-24 15:32
 **/

/**
 * 饿汉模式
 */
public class HungryMan {
    private HungryMan() {
    }

    private static HungryMan instance = new HungryMan();

    public static HungryMan getInstance() {
        return instance;
    }
}
