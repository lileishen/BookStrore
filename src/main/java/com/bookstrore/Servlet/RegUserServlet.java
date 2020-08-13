package com.bookstrore.Servlet;

import com.bookstrore.Service.UserService;
import com.bookstrore.ServiceImpl.UserServiceImpl;
import com.bookstrore.domain.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nono
 * @Package com.bookstrore.Servlet
 * @ClassName RegUserServlet.java
 * @Description TODO
 * @createTime 2020年08月10日 17:35:00
 */
public class RegUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        UserService userService = new UserServiceImpl();
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = new User(5,username, password, email);
        System.out.println(user);
        userService.existsUsername(user.getUsername());
        System.out.println("用户名存在");
        //检查验证码是否正确
//        if ("lyjh".equalsIgnoreCase(code)) {
//            if (userService.existsUsername(username)) {
//                System.out.println("用户名" + username + "已存在");
//                req.getRequestDispatcher("/pages/regist.html").forward(req, resp);
//            } else {
//                userService.regUser(user);
//                //跳转到注册成功页面
//                System.out.println("注册成功");
//                req.getRequestDispatcher("/pages/regist.html").forward(req, resp);
//            }
//
//        } else { //不正确   //请求转发，返回注册页面
//            System.out.println("验证码【" + code + "】有误");
//            req.getRequestDispatcher("/pages/regist.html").forward(req, resp);
//        }


    }
}
