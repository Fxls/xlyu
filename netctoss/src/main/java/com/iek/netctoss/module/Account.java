/**
 * @Author xlyu
 * @Date 2019/6/8
 * @Description
 */
package com.iek.netctoss.module;

import java.util.Objects;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-08 12:55
 **/
public class Account {
    public Account(){}
    private Integer id;
    private String login_name;
    private String login_pwd;

    public Account(Integer id, String login_name, String login_pwd) {
        this.id = id;
        this.login_name = login_name;
        this.login_pwd = login_pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_pwd() {
        return login_pwd;
    }

    public void setLogin_pwd(String login_pwd) {
        this.login_pwd = login_pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(login_name, account.login_name) &&
                Objects.equals(login_pwd, account.login_pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login_name, login_pwd);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login_name='" + login_name + '\'' +
                ", login_pwd='" + login_pwd + '\'' +
                '}';
    }
}
