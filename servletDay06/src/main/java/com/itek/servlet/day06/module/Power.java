/**
 * @Author xlyu
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servlet.day06.module;

import java.util.Objects;

/**
 * @program: servletDay06
 * @description: power实体类，（对应表power）
 * @author: xlyu
 * @create: 2019-05-29 15:47
 **/
public class Power {

    public Power() {
    }

    public Power(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return Objects.equals(id, power.id) &&
                Objects.equals(name, power.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
