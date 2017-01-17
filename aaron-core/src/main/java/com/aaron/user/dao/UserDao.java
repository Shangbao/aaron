package com.aaron.user.dao;

import com.aaron.user.model.UserVO;
import com.aaron.utils.annotation.MyBatisScan;
import org.apache.ibatis.annotations.Param;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:19:58
 */
@MyBatisScan
public interface UserDao {
    UserVO queryUserByLoginName(@Param("loginName")String loginName);
}
