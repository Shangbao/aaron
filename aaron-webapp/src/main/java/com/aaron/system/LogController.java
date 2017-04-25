package com.aaron.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/3/21
 * Time:16:10
 */
@Controller
@RequestMapping("/sys/log")
public class LogController {

    @RequestMapping("/index")
    public String index(){
        return "/system/logs/log";
    }
}
