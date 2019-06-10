/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.module;

import java.util.Date;
import java.util.Objects;

/**
 * @program: netctoss
 * @description: admin_info的实体类
 * @author: xlyu
 * @create: 2019-06-10 14:40
 **/


public class User {
    private Integer id;
    private String adminCode;
    private String pwd;
    private String name;
    private String telephone;
    private String email;
    private Date enrollDate;
    public User(){}

    public User(Integer id, String adminCode, String pwd,
                String name, String telephone, String email,
                Date enrollDate) {
        this.id = id;
        this.adminCode = adminCode;
        this.pwd = pwd;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrollDate = enrollDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(adminCode, user.adminCode) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(name, user.name) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(enrollDate, user.enrollDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminCode, pwd, name, telephone, email, enrollDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", adminCode='" + adminCode + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
