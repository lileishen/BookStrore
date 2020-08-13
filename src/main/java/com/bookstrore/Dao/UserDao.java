package com.bookstrore.Dao;

import com.bookstrore.domain.User;

/**
 * @author nono
 * @Package com.bookstrore.Dao
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2020年08月10日 15:53:00
 */
public interface UserDao {
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据用户查询用户信息
     * @param username
     * @return
     */
    public User queryByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param Password
     * @return
     */
    public User queryByUsernameAndPassWord(String username, String Password);


}
