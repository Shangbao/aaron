package com.aaron.user.service;

import com.aaron.user.model.UserVO;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:20:16
 */
public interface UserService {
    /**
     * 通过登录名称来获取用户信息
     * @param loginName 用户登录名
     * @return
     */
    public UserVO findUserByLoginName(String loginName)throws Exception;
}
