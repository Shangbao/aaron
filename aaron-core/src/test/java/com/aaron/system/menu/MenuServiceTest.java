package com.aaron.system.menu;

import com.aaron.system.menu.model.Menu;
import com.aaron.system.menu.service.MenuService;
import com.aaron.system.user.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 测试获得菜单
 * Creator:aaron_yong
 * Date:2017/4/23
 * Time:12:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    public void getMenuTree(){
        Map<String,Object> map=menuService.getMenuTree();
        System.out.println(JSONObject.fromObject(map).toString());
    }

    @Test
    public void getList(){

    }
}
