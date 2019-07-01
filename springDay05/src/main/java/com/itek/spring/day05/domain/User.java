/**
 * @Author xlyu
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.domain;

import java.util.Objects;

/**
 * @program: springDay04
 * @description:
 * @author: xlYu
 * @create: 2019-06-29 14:39
 **/
public class User {
    private Integer id;
    private String adminCode;
    private String password;

    public User() {
    }

    public User(Integer id, String adminCode, String password) {
        this.id = id;
        this.adminCode = adminCode;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return Objects.equals(id, user.id) &&
                Objects.equals(adminCode, user.adminCode) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminCode, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
