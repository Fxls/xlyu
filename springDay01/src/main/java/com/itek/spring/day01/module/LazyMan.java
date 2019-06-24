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
 * @create: 2019-06-24 15:09
 **/

import java.util.Objects;

/**
 * 单例类之懒汉模式
 */

public class LazyMan {
    private String name = "lazyMan";

    private static LazyMan instance = new LazyMan();

    private LazyMan() {
    }

    /**
     * 创建该类的静态工厂方法
     */
    public static LazyMan getInstance() {
        if (instance == null) {
            synchronized (LazyMan.class) {
                if (instance == null) {
                    instance = new LazyMan();
                }
            }
        }
        return instance;
    }

    private LazyMan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LazyMan lazyMan = (LazyMan) o;
        return Objects.equals(name, lazyMan.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "LazyMan{" +
                "name='" + name + '\'' +
                '}';
    }
}
