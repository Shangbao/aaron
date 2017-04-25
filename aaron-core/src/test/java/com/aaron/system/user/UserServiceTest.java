package com.aaron.system.user;


import com.aaron.system.user.model.User;
import com.aaron.system.user.service.UserService;
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
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetUserByUserName(){
        String username="admin";
        User loginUser=userService.getUserByUsername(username);
        if(null!=loginUser){
            System.out.println("username:"+loginUser.getUsername());
            System.out.println("password:"+loginUser.getPassword());
        }
    }

}
