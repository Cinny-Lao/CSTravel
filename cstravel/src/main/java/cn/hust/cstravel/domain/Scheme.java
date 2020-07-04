package cn.hust.cstravel.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 攻略方案实体类
 */
public class Scheme implements Serializable{
    private int sid; //攻略id
    private String sname; //攻略方案名称
    private String route; //行程安排描述
    private String food; //美食打卡描述
    private String hotel; //住宿建议描述
    private String attention; //注意事项
    private int cid; //所属分类（一日游？两日游？）
    private String simg; //略缩图
    private int favnum; //收藏数量
    private String introduction; //攻略方案简介

    private Category category; //所属分类
    private List<SchemeImg> schemeImgList; //攻略详情图列表

    public Scheme() {
    }

    public Scheme(int sid, String sname, String route, String food, String hotel, String attention, int cid, String simg, int favnum, String introduction, Category category, List<SchemeImg> schemeImgList) {
        this.sid = sid;
        this.sname = sname;
        this.route = route;
        this.food = food;
        this.hotel = hotel;
        this.attention = attention;
        this.cid = cid;
        this.simg = simg;
        this.favnum = favnum;
        this.introduction = introduction;
        this.category = category;
        this.schemeImgList = schemeImgList;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }

    public int getFavnum() {
        return favnum;
    }

    public void setFavnum(int favnum) {
        this.favnum = favnum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<SchemeImg> getSchemeImgList() {
        return schemeImgList;
    }

    public void setSchemeImgList(List<SchemeImg> schemeImgList) {
        this.schemeImgList = schemeImgList;
    }
}
