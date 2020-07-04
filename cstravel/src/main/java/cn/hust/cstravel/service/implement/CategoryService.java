package cn.hust.cstravel.service.implement;

import cn.hust.cstravel.dao.implement.CategoryDao;
import cn.hust.cstravel.domain.Category;
import cn.hust.cstravel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryService {

    public List<Category> findAll(){
        CategoryDao dao = new CategoryDao();
        List<Category> categories = null;
        Jedis jedis = JedisUtil.getJedis();
        //先从Jedis数据库里找数据
        Set<Tuple> jcategory = jedis.zrangeWithScores("category", 0, -1);
        //判断集合是否为空
        if(jcategory==null || jcategory.size()==0){
            //jedis数据库没有数据，从MySQL里找
            categories = dao.findAll();
            //并把数据缓存至jedis数据库中
            for (int i = 0; i < categories.size(); i++) {
                jedis.zadd("category",categories.get(i).getCid(),categories.get(i).getCname());
            }
        }
            //从jedis中取数据
            categories = new ArrayList<Category>();
            for (Tuple tuple: jcategory) {
                Category category = new Category();
                category.setCid((int)tuple.getScore());
                category.setCname(tuple.getElement());
                categories.add(category);

            }
        return categories;
    }
}
