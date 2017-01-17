package com.aaron.user;

import com.aaron.user.model.UserVO;
import com.aaron.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:19:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class User {

    @Autowired
    UserService userService;

    @Test
    public void queryUser() throws Exception {
        String loginName="tom";
        UserVO userVO=userService.findUserByLoginName(loginName);
        System.out.println(userVO.getLoginName());
    }
}
