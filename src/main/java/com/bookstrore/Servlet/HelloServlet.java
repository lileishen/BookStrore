package com.bookstrore.Servlet;


import com.bookstrore.Service.UserService;
import com.bookstrore.ServiceImpl.UserServiceImpl;
import com.bookstrore.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nono
 * @Package com.bookstrore.Servlet
 * @ClassName hello.java
 * @Description TODO
 * @createTime 2020年08月10日 23:32:00
 */
public class HelloServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("你好");
        UserService userService =new UserServiceImpl();
        User u =new User("user3","12345","user@qq.com");
        userService.regUser(u);
    }
}
