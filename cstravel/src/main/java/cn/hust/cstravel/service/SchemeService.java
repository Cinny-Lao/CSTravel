package cn.hust.cstravel.service;

import cn.hust.cstravel.domain.PageBean;
import cn.hust.cstravel.domain.Scheme;

public interface SchemeService {

    /**
     * 分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Scheme> pageQuery(int cid, int currentPage, int pageSize, String sname);
}
