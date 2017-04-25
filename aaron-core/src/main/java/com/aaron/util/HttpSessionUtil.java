package com.aaron.util;



import com.aaron.system.user.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pzw on 2/8/2016.
 */
public class HttpSessionUtil {

    private static final String USER_KEY = "user";


    /**
     * 设置用户到session
     * @param user 用户
     */
    public static void saveUserToSession(User user, HttpServletRequest request) {
        request.getSession().setAttribute(USER_KEY, user);
    }

//    /**
//     * 设置全局参数到session
//     *
//     * @param globalParam 全局参数
//     */
//    public static void saveGlobalParamToSession(GlobalParam globalParam, HttpSession session) {
//        session.setAttribute(globalParam.getParamName(), globalParam.getParamValue());
//    }

    /**
     * 从Session获取当前用户信息
     *
     * @return user
     */
    public static User getUserFromHttpSession(HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute(USER_KEY);
        return attribute == null ? null : (User) attribute;
    }

}
