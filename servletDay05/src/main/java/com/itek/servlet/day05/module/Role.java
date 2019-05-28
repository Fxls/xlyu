/**
 * @Author xlyu
 * @Date 2019/5/28
 * @Description
 */
package com.itek.servlet.day05.module;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: servletDay05
 * @description: role实体类
 * @author: xlyu
 * @create: 2019-05-28 16:27
 **/
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String priviege;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriviege() {
        return priviege;
    }

    public void setPriviege(String priviege) {
        this.priviege = priviege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(Integer id, String name, String priviege) {
        this.id = id;
        this.name = name;
        this.priviege = priviege;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priviege='" + priviege + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(priviege, role.priviege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priviege);
    }
}
