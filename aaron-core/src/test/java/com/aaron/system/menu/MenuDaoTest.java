package com.aaron.system.menu;

import com.aaron.system.menu.dao.MenuDao;
import com.aaron.system.menu.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/4/23
 * Time:12:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class MenuDaoTest {

    @Autowired
    MenuDao menuDao;

    @Test
    public void testGetMenus(){
        List<Menu> menus=menuDao.getAllMenu();
        if(null!=menus){
            for(Menu menu:menus){
                System.out.print("menuId:"+menu.getId()+"\t");
                System.out.print("menueName"+menu.getMenuName()+"\t");
                System.out.print("parentId:"+menu.getParentId()+"\t");
            }
        }
    }

    @Test
    public void testGetMenuListByParentId(){
        String parentId="01000000";
        List<Menu> menus=menuDao.getMenuListByParentId(parentId);
        if(null!=menus&&menus.size()>0){
            for(Menu menu:menus){
                System.out.print("menuId:"+menu.getId()+"\t");
                System.out.print("menueName"+menu.getMenuName()+"\t");
                System.out.print("parentId:"+menu.getParentId()+"\t");
            }
        }
    }
}
