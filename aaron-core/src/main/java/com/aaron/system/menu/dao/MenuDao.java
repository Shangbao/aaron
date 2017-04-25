package com.aaron.system.menu.dao;



import com.aaron.annotation.RepositoryImpl;
import com.aaron.system.menu.model.Menu;

import java.util.List;

/**
 * Created by pzw on 2/8/2016.
 */
@RepositoryImpl
public interface MenuDao {

    List<Menu> getAllMenu();

    List<Menu> getMenuListByLevel(Integer level);

    List<Menu> getMenuListByParentId(String parentId);

    List<Menu> getPermissionTree();

}
