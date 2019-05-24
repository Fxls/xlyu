/**
 * @Author xlyu
 * @Date 2019/5/23
 * @Description
 */
package com.itek.servlet.day02;

/**
 * @program: servletDay02
 * @description:
 * @author: xlyu
 * @create: 2019-05-23 23:16
 **/
public class Account {
    private int account_id;
    private String real_name;
    private String login_name;
    private String idcard_no;
    private String telephone;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getIdcard_no() {
        return idcard_no;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Account(int account_id, String real_name, String login_name, String idcard_no, String telephone) {
        this.account_id = account_id;
        this.real_name = real_name;
        this.login_name = login_name;
        this.idcard_no = idcard_no;
        this.telephone = telephone;
    }
}
