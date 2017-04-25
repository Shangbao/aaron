package com.aaron.system.role.service;

import com.aaron.constant.Constant;
import com.aaron.system.role.dao.RoleDao;
import com.aaron.system.role.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pzw on 2/10/2016.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public List<Role> getAllRoleList() {
        return roleDao.getAllRoleList();
    }

    /*public List<Role> getRoleListPage(Page page,Role role) {
        PageInterceptor.startPage(page);
        return roleDao.getRoleListPage(role);
    }*/

    public boolean addRole(Role role) {
        int a = roleDao.addRole(role);
        int b = roleDao.addRolePermission(role);
        return a + b > Constant.FUNCTION_RETURN;
    }

    public boolean delRoleById(String id) {
        int a = roleDao.delRolePermissionByRoleId(id);
        int b = roleDao.delRoleById(id);
        return a + b > Constant.FUNCTION_RETURN;
    }

    public Role getRoleById(String id) {
        return roleDao.getRoleById(id);
    }

    public boolean updateRole(Role role) {
        int a = roleDao.updateRole(role);
        int b = roleDao.delRolePermissionByRoleId(role.getId());
        int c = roleDao.addRolePermission(role);
        return a + b + c > Constant.FUNCTION_RETURN;
    }

}
