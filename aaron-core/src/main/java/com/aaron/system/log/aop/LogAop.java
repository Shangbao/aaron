package com.aaron.system.log.aop;

import org.springframework.stereotype.Component;

/**
 * Created by panzhuowen on 2016/3/5 001.
 */
@Component
//@Aspect
public class LogAop {
   /* @Autowired
    private SystemLogService logService;


    @Pointcut("execution(* com.internet..*.*Controller.*(..))")
    public void logPointCut() {
    }
    @AfterReturning(value = "logPointCut()",returning = "rov")
    public void afterReturning(Object rov) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request.getRequestURI().contains(".jsp")) {
            return;
        }
        StringBuilder params = new StringBuilder();
        int index = 0;
        for (String param : request.getParameterMap().keySet()) {
            params.append(index++ == 0 ? "" : "&").append(param).append("=").append(request.getParameter(param));
        }
        SystemLog log = new SystemLog();
        Subject user = SecurityUtils.getSubject();
        if (user != null && user.getPrincipal() != null) {
            log.setUsername(user.getPrincipal().toString());
        } else {
            log.setUsername("游客");
        }
        log.setDate(new Date());
        log.setIp(getIp(request));
        log.setUserAgent(request.getHeader("user-agent"));
        log.setUrl(request.getRequestURI());
        log.setMethod(request.getMethod());
        log.setParams(params.toString());
        logService.insertSystemLog(log);
    }
    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }*/
}
