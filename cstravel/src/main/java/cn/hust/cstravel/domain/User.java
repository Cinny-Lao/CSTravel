package cn.hust.cstravel.domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable{
    private int uid; //用户id
    private String username; //用户昵称
    private String password; //用户密码
    private String sex; //性别
    private String telephone; //手机号
    private String email; //邮箱
    private String birthday; //生日

    public User() {
    }

    public User(int uid, String username, String password, String sex, String telephone, String email, String birthday) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.birthday = birthday;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
