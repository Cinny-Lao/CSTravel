package cn.hust.cstravel.dao;

import cn.hust.cstravel.domain.Scheme;

import java.util.List;

public interface SchemeDao {
    /**
     * 查询总记录数
     * @param cid
     * @return
     */
    public int count(int cid, String sname);

    /**
     * 根据cid分页查询
     * @param cid
     * @param start
     * @param PageSize
     * @return
     */
    public List<Scheme> findByPage(int cid, int start, int PageSize, String sname);
}
