package com.aaron.system.user.dao;



import com.aaron.annotation.RepositoryImpl;
import com.aaron.system.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by pzw on 2/2/2016.
 */
@RepositoryImpl("userDao")
public interface UserDao {

    /*
    List<User> getUserListPage(User user);
    User getUserByUsername(String username);
    List<String> getPermTokenByUsername(String username);
    int delUserById(String id);
    User getUserById(String id);
    int delUserRoleByUserId(String userId);
    int addUser(User user);
    int addUserRole(User user);
    int updateUser(User user);
    int updateUserRole(User user);
    boolean updatePassword(User user);
    boolean updateNickName(User user);
    boolean updateUserName(User user);
    String checkUserName(String userName);
    */

    User getUserByUsername(@Param("username") String username);

    List<String> getPermTokenByUsername(String username);

}
