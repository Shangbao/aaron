package com.aaron.admin;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/3/21
 * Time:19:02
 */
//@Controller
//@RequestMapping("/admin")
public class AdminLoginController {
/*
    @Autowired
    UserService userService;

    @RequestMapping(value ="login",method = RequestMethod.GET)
    public String loginPage(){
        return "/admin/login";
    }

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String login(User user,HttpServletRequest request){
        Subject currentUser= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            currentUser.login(token);
        }catch (AuthenticationException e){
            return "redirect:/admin/login";
        }
        if(currentUser.isAuthenticated()){
            sessionHandler(user,request);
            return "redirect:"+getSavedUrl(request);
        }else{
            return "redirect:/admin/login";
        }
    }

    public String getSavedUrl(HttpServletRequest request){
        SavedRequest savedRequest= WebUtils.getAndClearSavedRequest(request);
        if (savedRequest == null) {
            return "/admin/index";
        }
        String savedUrl = savedRequest.getRequestUrl().replaceFirst(request.getContextPath(), "");
        if (!savedUrl.contains("menuId")) {
            savedUrl = "/admin/index";
        }
        return savedUrl;
    }

    public void sessionHandler(User user, HttpServletRequest request){
        User loginUser=userService.getUserByUsername(user.getUsername());
        saveUserToSession(loginUser,request);
    }*/


}
