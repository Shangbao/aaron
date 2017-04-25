package com.aaron.shiro;


import com.aaron.system.role.model.Role;
import com.aaron.system.user.model.User;
import com.aaron.system.user.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by pzw on 2/8/2016.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        if (username != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Role role = userService.getUserByUsername(username).getRole();
            if (role != null) {
                info.addRole(role.getRoleName());
            }
            List<String> permTokens = userService.getUserPermTokenByUsername(username);
            if (permTokens != null) {
                info.addStringPermissions(permTokens);
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if (username != null && !"".equals(username)) {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            }
        }
        return null;
    }
}
