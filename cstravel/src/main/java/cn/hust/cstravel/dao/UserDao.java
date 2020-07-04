package cn.hust.cstravel.dao;

import cn.hust.cstravel.domain.User;

public interface UserDao {
    /**
     *根据手机号查询用户
     * @return
     */
    public User findByTel(User user);

    /**
     * 根据昵称查询用户
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     */
    public void save(User user);

    /**
     * 根据手机号和密码查询用户
     * @param telephone
     * @param password
     * @return
     */
    public User findByTelAndPass(String telephone, String password);

    /**
     * 根据昵称和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPass(String username, String password);
}
