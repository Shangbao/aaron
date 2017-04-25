package com.aaron.system.log.service;


import com.aaron.constant.Constant;
import com.aaron.system.log.dao.LogDao;
import com.aaron.system.log.model.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by panzhuowen on 2016/3/4 001.
 */
@Service
public class SystemLogService {

    @Autowired
    private LogDao logDao;


    public boolean insertSystemLog(SystemLog systemLog) {
        return logDao.insertSystemLog(systemLog) == Constant.FUNCTION_RETURN;
    }

    /*public List<SystemLog> getSystemLogListPage(Page page, SystemLog systemLog) {
        PageInterceptor.startPage(page);
        return logDao.getSystemLogListPage(systemLog);
    }*/

}
