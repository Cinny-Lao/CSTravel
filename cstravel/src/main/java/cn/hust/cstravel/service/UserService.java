package cn.hust.cstravel.service;

import cn.hust.cstravel.domain.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * 查询用户昵称是否存在
     * @param username
     * @return
     */
    public boolean checkUsername(String username);

    /**
     * 根据手机号和密码进行登录
     * @param telephone
     * @param password
     * @return
     */
    public User loginByTelAndPass(String telephone, String password);

    /**
     * 根据昵称和密码进行登录
     * @param username
     * @param password
     * @return
     */
    public User loginByUsernameAndPass(String username, String password);
}
