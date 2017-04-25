package com.aaron.system.menu.service;


import com.aaron.constant.Constant;
import com.aaron.system.menu.dao.MenuDao;
import com.aaron.system.menu.model.Menu;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * Creator:aaron_yong
 * Date:2017/4/23
 * Time:12:37
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;


    public Map<String,Object> getMenuTree(){
        //获得menu组装成功的json数据
        Map<String,Object> menuResult=new HashMap<String,Object>();
        //取得所有一级菜单
        List<Menu> menusRoot=menuDao.getMenuListByParentId(Constant.MENU_CODE_ROOT);
        recursiveMenuTree(menusRoot,menuResult);
        //获得组装成功的树结构菜单
        List<Map<String,Object>> menus= (List<Map<String, Object>>) menuResult.get("children");
        if(null!=menus&&menus.size()>0){
            menuResult.put("success",true);
        }else{
            menuResult.put("success",false);
        }
        return menuResult;
    }

    public void recursiveMenuTree(List<Menu> menus,Map<String,Object> menuResult){
        //组装当前递归节点的父节点菜单
        List<Map<String,Object>> parentManus=new ArrayList<>();
        //用于临时组装总体叶子节点菜单
        List<Menu> leafMenus=new ArrayList<>();
        if(null!=menus&&menus.size()>0){
            for(Menu tempMenu:menus){
                //用于组装当前节点map
                Map<String,Object> currentMenuMap=new HashMap<String,Object>();
                List<Menu> children=menuDao.getMenuListByParentId(tempMenu.getId());
                if(children!=null&&children.size()>0){
                    currentMenuMap.put("menu",tempMenu);
                    currentMenuMap.put("hasChild",true);
                    recursiveMenuTree(children,currentMenuMap);
                    parentManus.add(currentMenuMap);
                }else{
                    leafMenus.add(tempMenu);
                }
            }
            if(null!=leafMenus&&leafMenus.size()>0){
                menuResult.put("children",leafMenus);
                return;
            }
        }
        menuResult.put("children",parentManus);
    }



    /*private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }



    @PostConstruct
    public void initMenuContext() {
        if (servletContext != null) {
            List<Menu> menuList = menuDao.getAllMenu();
            Map<String, Menu> menuMap = new HashMap<>();
            for (Menu menu : menuList) {
                menuMap.put(String.valueOf(menu.getId()), menu);
            }
            servletContext.setAttribute("menuMap", menuMap);
        }
    }

    public void updateMenuInHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Menu> level0List = new ArrayList<>();
        Subject currentUser = SecurityUtils.getSubject();
        menuDao.getMenuListByLevel(0).stream().filter(menu -> StringUtil.isEmpty(menu.getPermission().getPermToken())
                || currentUser.isPermitted(menu.getPermission().getPermToken())).forEach(menu -> {
            level0List.add(menuUrlHandle(menu));
        });

        List<Menu> level1List = menuDao.getMenuListByLevel(1);
        Map<String, List<Menu>> level1Map = groupMenuList(level1List);

        List<Menu> level2List = menuDao.getMenuListByLevel(2);
        Map<String, List<Menu>> level2Map = groupMenuList(level2List);

        session.setAttribute("level0List", level0List);
        session.setAttribute("level1Map", level1Map);
        session.setAttribute("level2Map", level2Map);
    }

    private Map<String, List<Menu>> groupMenuList(List<Menu> menuList) {
        Subject currentUser = SecurityUtils.getSubject();
        Map<String, List<Menu>> map = new HashMap<>();
        for (Menu menu : menuList) {
            if (!map.containsKey(menu.getParentId())) {
                map.put(menu.getParentId(), new ArrayList<>());
            }
            if ("".equals(menu.getPermission().getPermToken()) || currentUser.isPermitted(menu.getPermission().getPermToken())) {
                map.get(menu.getParentId()).add(menuUrlHandle(menu));
            }
        }
        return map;
    }

    private Menu menuUrlHandle(Menu menu) {
        String url = menu.getUrl();
        menu.setUrl(url + (url.contains("?") ? "&" : "?") + "menuId=" + menu.getId());
        return menu;
    }

    public List<Menu> getMenuList() {
        return menuDao.getPermissionTree();
    }*/

}
