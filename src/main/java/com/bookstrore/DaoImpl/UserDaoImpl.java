package com.bookstrore.DaoImpl;

import com.bookstrore.Dao.BaseDao;
import com.bookstrore.Dao.UserDao;
import com.bookstrore.domain.User;

/**
 * @author nono
 * @Package com.bookstrore.DaoImpl
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2020年08月10日 16:21:00
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryByUsername(String username) {
        String sql="select * from t_user where username=?";
        //System.out.println("UserDaoImpl:"+username);
        return queryForOne(sql,User.class , username);
    }

    @Override
    public User queryByUsernameAndPassWord(String username, String Password) {
        String sql="select * from t_user where username=? and password=?";
        return queryForOne(sql,User.class,username,Password);
    }
}
