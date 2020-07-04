package cn.hust.cstravel.service.implement;

import cn.hust.cstravel.dao.SchemeDao;
import cn.hust.cstravel.dao.implement.SchemeDaoI;
import cn.hust.cstravel.domain.PageBean;
import cn.hust.cstravel.domain.Scheme;
import cn.hust.cstravel.service.SchemeService;

import java.util.List;

public class SchemeServiceI implements SchemeService{
   private SchemeDao dao = new SchemeDaoI();

    @Override
    public PageBean<Scheme> pageQuery(int cid, int currentPage, int pageSize, String sname) {
        PageBean<Scheme> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //总记录数
        int totalCount = dao.count(cid,sname);
        pageBean.setTotalCount(totalCount);
        //分页查询的开始索引
        int start = (currentPage-1)*pageSize;
        List<Scheme> pageList = dao.findByPage(cid, start, pageSize,sname);
        pageBean.setPagelist(pageList);
        //总页数
        int totalPage = totalCount % pageSize==0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
