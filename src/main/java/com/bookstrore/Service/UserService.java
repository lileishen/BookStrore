package com.bookstrore.Service;

import com.bookstrore.domain.User;

/**
 * @author nono
 * @Package com.bookstrore.Service
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年08月10日 16:47:00
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     */
    public void regUser(User user);

    /**
     * 登录
     *
     * @return
     */
    public User login(User user);

    /**
     * 根据用户名检查用户是否存在
     *
     * @param username
     * @return
     */
    public boolean existsUsername(String username);

}
