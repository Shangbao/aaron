package com.aaron.user;

import com.aaron.BaseController;
import com.aaron.user.model.UserVO;
import com.aaron.user.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:20:14
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    Map<String,Object> resultMap;

    @RequestMapping(value = "/showUser",method = {RequestMethod.GET},produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String showUser(HttpServletRequest request){
        try{
            String loginName=request.getParameter("loginName");
            UserVO userVO=userService.findUserByLoginName(loginName);
            resultMap=new HashMap<String,Object>();
            if(null==userVO){
                resultMap.put("success",false);
                return JSONObject.fromObject(userVO).toString();
            }
            resultMap.put("success",true);
            resultMap.put("user",userVO);
            return JSONObject.fromObject(resultMap).toString();
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("success",false);
            return  JSONObject.fromObject(resultMap).toString();
        }
    }

}
