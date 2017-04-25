package com.aaron.system.user.service;

import com.aaron.system.user.model.User;

import java.util.List;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/4/22
 * Time:16:51
 */
public interface UserService {
    User getUserByUsername(String username);

    List<String> getUserPermTokenByUsername(String username);
}
