package cn.hust.cstravel.dao.implement;

import cn.hust.cstravel.dao.SchemeDao;
import cn.hust.cstravel.domain.Scheme;
import cn.hust.cstravel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class SchemeDaoI implements SchemeDao{
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询总记录数
     * @param cid
     * @return
     */
    @Override
    public int count(int cid, String sname) {
        String sql = "select count(*) from scheme where 1=1 ";
        StringBuffer sb = new StringBuffer(sql);
        List params = new ArrayList();
        if(cid!=0){
            sb.append(" and cid=? ");
            params.add(cid);
        }
        if(sname!=null && sname.length()>0 && !"null".equals(sname)){
            sb.append(" and sname like ? ");
            params.add("%"+sname+"%");
        }
        sql = sb.toString();
        return template.queryForObject(sql,Integer.class,params.toArray());

    }

    /**
     * 分页查询
     * @param cid
     * @param start
     * @param PageSize
     * @return
     */
    @Override
    public List<Scheme> findByPage(int cid, int start, int PageSize, String sname) {
        //String sql = "select * from scheme where cid = ? limit ? , ? ";
        String sql = "select * from scheme where 1=1  ";
        StringBuffer sb = new StringBuffer(sql);
        List params = new ArrayList();
        if(cid!=0){
            sb.append(" and cid=? ");
            params.add(cid);
        }
        if(sname!=null && sname.length()>0 && !"null".equals(sname)){
            sb.append(" and sname like ? ");
            params.add("%"+sname+"%");
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(PageSize);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Scheme>(Scheme.class), params.toArray());

    }
}
