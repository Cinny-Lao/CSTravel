package cn.hust.cstravel.domain;

import java.io.Serializable;

/**
 * 攻略详情图片实体类
 */
public class SchemeImg implements Serializable{
    private int sgid; //详情图id
    private int sid; //攻略详情方案id
    private String picture; //详情图片

    public SchemeImg() {
    }

    public SchemeImg(int sgid, int sid, String picture) {
        this.sgid = sgid;
        this.sid = sid;
        this.picture = picture;
    }

    public int getSgid() {
        return sgid;
    }

    public void setSgid(int sgid) {
        this.sgid = sgid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
