/**
 * @Author xlyu
 * @Date 2019/6/24
 * @Description
 */
package com.itek.spring.day01.module;

import java.util.Objects;

/**
 * @program: springDay01
 * @description:
 * @author: xlyu
 * @create: 2019-06-24 09:58
 **/
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
        System.out.println("这里是构造器");
    }

    public void init() {
        System.out.println("init回调");
    }

    public void destroy() {
        System.out.println("destroy回调");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
