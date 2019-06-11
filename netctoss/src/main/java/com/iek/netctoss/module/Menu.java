/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.module;

import java.util.Objects;

/**
 * @program: netctoss
 * @description: Menu实体类
 * @author: xlyu
 * @create: 2019-06-11 08:59
 **/
public class Menu {
    public Menu() {
    }

    public Menu(Integer id, String href, String clazz, String name) {
        this.id = id;
        this.href = href;
        this.clazz = clazz;
        this.name = name;
    }

    private Integer id;
    private String href;
    private String clazz;
    private String name;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", clazz='" + clazz + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(clazz, menu.clazz) &&
                Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, clazz, name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
