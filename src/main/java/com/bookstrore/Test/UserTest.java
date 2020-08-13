package com.bookstrore.Test;

import com.bookstrore.Service.UserService;
import com.bookstrore.ServiceImpl.UserServiceImpl;
import com.bookstrore.domain.User;
import org.junit.Test;

/**
 * @author nono
 * @Package com.bookstrore.Test
 * @ClassName UserTest.java
 * @Description TODO
 * @createTime 2020年08月10日 16:43:00
 */
public class UserTest {
    @Test
    public void usertest(){
        UserService userService =new UserServiceImpl();
        User u =new User("admin","12345","user@qq.com");
      //  userService.regUser(u);
//        boolean b = userService.existsUsername("123");
//        System.out.println(b);

        User user =new User("admin", "12345");
        User user1 = userService.login(user);
        System.out.println(user1);
    }
}
