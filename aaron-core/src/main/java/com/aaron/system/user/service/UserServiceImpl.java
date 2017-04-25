package com.aaron.system.user.service;


import com.aaron.constant.Constant;
import com.aaron.system.user.dao.UserDao;
import com.aaron.system.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pzw on 2/2/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<String> getUserPermTokenByUsername(String username) {
        return userDao.getPermTokenByUsername(username);
    }
}
