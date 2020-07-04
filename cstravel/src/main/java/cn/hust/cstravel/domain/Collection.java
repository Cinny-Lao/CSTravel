package cn.hust.cstravel.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏实体类
 */
public class Collection implements Serializable{
    private Scheme scheme; //攻略方案对象
    private User user; //所属用户对象
    private Date date; //收藏时间

    public Collection() {
    }

    public Collection(Scheme scheme, User user, Date date) {
        this.scheme = scheme;
        this.user = user;
        this.date = date;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
