package cn.hust.cstravel.dao.implement;

import cn.hust.cstravel.dao.UserDao;
import cn.hust.cstravel.domain.User;
import cn.hust.cstravel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoI implements UserDao{
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据手机号查询用户
     * @return
     */
    @Override
    public User findByTel(User user) {
        String sql = "select * from user where telephone = ? ";
        User u = null;
        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getTelephone());
        } catch (DataAccessException e) {

        }
        return u;
    }

    /**
     * 根据昵称查询用户
     * @return
     */
    @Override
    public User findByUsername(String username) {
        String sql = "select * from user where username = ? ";
        User u = null;
        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {

        }
        return u;
    }

    /**
     * 保存用户信息
     * @param user
     */
    @Override
    public void save(User user) {
        String sql = "insert into user(username, password, sex, telephone, email, birthday) values(?,?,?,?,?,?)";
        System.out.println(user);
        template.update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getTelephone(), user.getEmail(), user.getBirthday());

    }

    /**
     * 根据手机号和密码查询用户
     * @param telephone
     * @param password
     * @return
     */
    @Override
    public User findByTelAndPass(String telephone, String password) {
        String sql = "select * from user where telephone = ? and password = ? ";
        User u = null;
        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), telephone, password);
        } catch (DataAccessException e) {

        }
        return u;
    }

    @Override
    public User findByUsernameAndPass(String username, String password) {
        String sql = "select * from user where username = ? and password = ? ";
        User u = null;
        try {
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {

        }
        return u;
    }
}
