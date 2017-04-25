package com.aaron.system.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/4/20
 * Time:8:17
 */
@Controller
@RequestMapping("/sys/home")
public class HomeController{

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "system/index";
    }


}
