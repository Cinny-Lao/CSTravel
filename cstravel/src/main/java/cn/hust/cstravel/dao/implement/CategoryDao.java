package cn.hust.cstravel.dao.implement;

import cn.hust.cstravel.domain.Category;
import cn.hust.cstravel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Category> findAll(){
        String sql = "select * from category";
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
