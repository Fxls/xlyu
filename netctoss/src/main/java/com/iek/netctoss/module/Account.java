/**
 * @Author xlyu
 * @Date 2019/6/11
 * @Description
 */
package com.iek.netctoss.module;

import java.util.Date;
import java.util.Objects;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-11 10:29
 **/
public class Account {
    private Integer id;
    private Integer recommenderId;
    private String loginName;
    private String loginPasswd;
    private String status;
    private Date createDate;
    private Date pauseDate;
    private Date closeDate;
    private String realName;
    private String idcardNo;
    private Date birthdate;
    private String gender;
    private String occupation;
    private String telephone;
    private String email;
    private String mailaddress;
    private String zipcode;
    private String qq;
    private Date lastLoginTime;
    private String lastLoginIp;

    public Account() {
    }

    public Account(Integer id,
                   String realName,
                   String idcardNo,
                   String loginName,
                   String status,
                   Date createDate,
                   Date lastLoginTime) {
        this.id = id;
        this.realName = realName;
        this.idcardNo = idcardNo;
        this.loginName = loginName;
        this.status = status;
        this.createDate = createDate;
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", recommenderId=" + recommenderId +
                ", loginName='" + loginName + '\'' +
                ", loginPasswd='" + loginPasswd + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", pauseDate=" + pauseDate +
                ", closeDate=" + closeDate +
                ", realName='" + realName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", mailaddress='" + mailaddress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", qq='" + qq + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(recommenderId, account.recommenderId) &&
                Objects.equals(loginName, account.loginName) &&
                Objects.equals(loginPasswd, account.loginPasswd) &&
                Objects.equals(status, account.status) &&
                Objects.equals(createDate, account.createDate) &&
                Objects.equals(pauseDate, account.pauseDate) &&
                Objects.equals(closeDate, account.closeDate) &&
                Objects.equals(realName, account.realName) &&
                Objects.equals(idcardNo, account.idcardNo) &&
                Objects.equals(birthdate, account.birthdate) &&
                Objects.equals(gender, account.gender) &&
                Objects.equals(occupation, account.occupation) &&
                Objects.equals(telephone, account.telephone) &&
                Objects.equals(email, account.email) &&
                Objects.equals(mailaddress, account.mailaddress) &&
                Objects.equals(zipcode, account.zipcode) &&
                Objects.equals(qq, account.qq) &&
                Objects.equals(lastLoginTime, account.lastLoginTime) &&
                Objects.equals(lastLoginIp, account.lastLoginIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recommenderId, loginName, loginPasswd, status, createDate, pauseDate, closeDate, realName, idcardNo, birthdate, gender, occupation, telephone, email, mailaddress, zipcode, qq, lastLoginTime, lastLoginIp);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Integer recommenderId) {
        this.recommenderId = recommenderId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}
