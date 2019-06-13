/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.module;

import java.util.Objects;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 22:54
 **/
public class Area {
    public Area() {
    }

    public Area(Integer id, String code, String name, String citycode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.citycode = citycode;
    }


    private Integer id;
    private String code;
    private String name;
    private String citycode;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", citycode='" + citycode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(code, area.code) &&
                Objects.equals(name, area.name) &&
                Objects.equals(citycode, area.citycode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, citycode);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
}
