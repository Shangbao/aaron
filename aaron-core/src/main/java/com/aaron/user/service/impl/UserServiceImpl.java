package com.aaron.user.service.impl;

import com.aaron.user.dao.UserDao;
import com.aaron.user.model.UserVO;
import com.aaron.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:20:16
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public UserVO findUserByLoginName(String loginName) throws Exception {
        return userDao.queryUserByLoginName(loginName);
    }
}
