package com.bookstrore.ServiceImpl;

import com.bookstrore.Dao.UserDao;
import com.bookstrore.DaoImpl.UserDaoImpl;
import com.bookstrore.Service.UserService;
import com.bookstrore.domain.User;

/**
 * @author nono
 * @Package com.bookstrore.ServiceImpl
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年08月10日 16:55:00
 */
public class UserServiceImpl implements UserService {
    private UserDao udao=new UserDaoImpl();

    @Override
    public void regUser(User user) {
        udao.saveUser(user);
    }

    @Override
    public User login(User user) {

        return udao.queryByUsernameAndPassWord(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        User user = udao.queryByUsername(username);
        if (user!=null){
            return true;
        }
        return false;
    }
}
