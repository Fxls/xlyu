/**
 * @Author xlyu
 * @Date 2019/5/24
 * @Description
 */
package com.itek.servlet.day03.module;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: servletDay03
 * @description: account的实体类
 * @author: xlyu
 * @create: 2019-05-24 14:19
 **/
public class Account implements Serializable {

    private static final long serialVersionUID = 5598650492985523981L;
    private Integer account_id;//id
    private String login_name;//登录名
    private String status;//开通状态
    private String real_name;//真实姓名
    private String idcard_no;//身份证号
    private String telephone;//手机号

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
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

    public Account(Integer account_id, String login_name, String status, String real_name, String idcard_no, String telephone) {
        this.account_id = account_id;
        this.login_name = login_name;
        this.status = status;
        this.real_name = real_name;
        this.idcard_no = idcard_no;
        this.telephone = telephone;
    }
}
