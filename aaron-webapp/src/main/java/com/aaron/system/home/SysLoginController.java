package com.aaron.system.home;

import com.aaron.BaseController;
import com.aaron.system.menu.service.MenuService;
import com.aaron.system.user.model.User;
import com.aaron.system.user.service.UserService;
import com.aaron.system.user.service.UserServiceImpl;
import com.aaron.util.CryptographyUtil;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 管理员登录控制器
 * Creator:aaron_yong
 * Date:2017/4/20
 * Time:8:17
 */
@Controller
@RequestMapping("/sys/login")
public class SysLoginController extends BaseController{

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String login(){
        return "system/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginPost(@Param("user") User user, RedirectAttributes redirectAttributes, HttpServletRequest request){
        user.setPassword(CryptographyUtil.md5(user.getPassword()));
        Subject currentUser= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            currentUser.login(token);
        }catch (AuthenticationException e){
            redirectAttributes.addFlashAttribute("message","loginPrompt");
            logger.info("error",e);
            return "redirect:/sys/login";
        }
        if(currentUser.isAuthenticated()){
            sessionHandle(user,request);
            return "redirect:/sys/home/index";
        }else {
            redirectAttributes.addFlashAttribute("message", "loginPrompt");
            return "redirect:/login";
        }
    }

    private void sessionHandle(User user,HttpServletRequest request){
        User loginUser=userService.getUserByUsername(user.getUsername());
        this.saveMenuTreeToSession(request);
        this.saveUserToSession(loginUser,request);
    }

    private void saveMenuTreeToSession(HttpServletRequest request){
        Map<String,Object> menuTree=menuService.getMenuTree();
        User user=getUserFromSession(request);
        if(null==user){
            request.getSession().setAttribute("menuTree", menuTree);
        }
    }



}
