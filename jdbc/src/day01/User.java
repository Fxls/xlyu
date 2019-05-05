/**
 * @Author xlyu
 * @Date 2019/4/30
 * @Description
 */
package day01;

/**
 * @program: jdbc
 * @description:
 * @author: xlyu
 * @create: 2019-04-30 16:06
 **/
public class User {

    private Integer id;
    private String phoneNUmber;
    private String pwd;
    private String nickname;

    public User() {
    }

    public User(String phoneNumber, String pwd,String nickname) {
        this.phoneNUmber = phoneNumber;
        this.pwd = pwd;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNUmber='" + phoneNUmber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
