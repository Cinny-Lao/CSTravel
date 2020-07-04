package cn.hust.cstravel.service.implement;

import cn.hust.cstravel.dao.UserDao;
import cn.hust.cstravel.dao.implement.UserDaoI;
import cn.hust.cstravel.domain.User;
import cn.hust.cstravel.service.UserService;

public class UserServiceI implements UserService{
    UserDao dao = new UserDaoI();

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        User u = dao.findByTel(user);
        //用户已存在
        if(u!=null)
            return false;
        //用户不存在
        dao.save(user);
        return true;
    }

    @Override
    public boolean checkUsername(String username) {
        User user = dao.findByUsername(username);
        //昵称不存在
        if(user==null)
            return true;
        //昵称已存在
        return false;
    }

    @Override
    public User loginByTelAndPass(String telephone, String password) {
        return dao.findByTelAndPass(telephone,password);

    }

    @Override
    public User loginByUsernameAndPass(String username, String password) {
        return  dao.findByUsernameAndPass(username, password);

    }


}
