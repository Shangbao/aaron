package com.aaron;

import com.aaron.system.user.model.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:20:14
 */
@Controller
public class BaseController {

    private static final String USER_KEY = "user";

    /**
     * 设置管理员信息到session
     * @param user
     * @param request
     */
    public void saveUserToSession(User user, HttpServletRequest request){
        request.getSession().setAttribute(USER_KEY,user);
    }

    /**
     * 从session里面获得管理员信息
     * @param request
     * @return
     */
    public User getUserFromSession(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute(USER_KEY);
         return  user==null?null:user;
    }

}
