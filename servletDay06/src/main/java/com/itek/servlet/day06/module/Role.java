/**
 * @Author xlyu
 * @Date 2019/5/29
 * @Description
 */
package com.itek.servlet.day06.module;

/**
 * @program: servletDay06
 * @description: role实体类（对应表role）
 * @author: xlyu
 * @create: 2019-05-29 14:29
 **/


public class Role {

    public Role() {
    }


    public Role(Integer id, String name, String powerNames) {
        this.id = id;
        this.name = name;
        this.powerNames = powerNames;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    private Integer id;
    private String name;
    private String powerNames;


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

    public String getPowerNames() {
        return powerNames;
    }

    public void setPowerNames(String powerNames) {
        this.powerNames = powerNames;
    }


}
