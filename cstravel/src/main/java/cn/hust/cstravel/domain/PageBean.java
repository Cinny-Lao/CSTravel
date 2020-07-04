package cn.hust.cstravel.domain;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
    private  int totalCount; //总记录数
    private int currentPage; //当前页码
    private int totalPage; //总页数
    private int pageSize; //每页显示条数
    private List<T> pagelist; //每页显示的数据集合

    public PageBean() {
    }

    public PageBean(int totalCount, int currentPage, int totalPage, int pageSize, List<T> pagelist) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.pagelist = pagelist;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPagelist() {
        return pagelist;
    }

    public void setPagelist(List<T> pagelist) {
        this.pagelist = pagelist;
    }
}
