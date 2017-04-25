package com.aaron.system.role.dao;



import com.aaron.annotation.RepositoryImpl;
import com.aaron.system.role.model.Role;

import java.util.List;

/**
 * Created by pzw on 2/10/2016.
 */
@RepositoryImpl
public interface RoleDao {

    List<Role> getAllRoleList();

    List<Role> getRoleListPage(Role role);

    Role getRoleById(String id);

    int addRole(Role role);

    int addRolePermission(Role role);

    int delRolePermissionByRoleId(String roleId);

    int delRoleById(String id);

    int updateRole(Role role);

}
