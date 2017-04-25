package com.aaron.system.log.dao;



import com.aaron.annotation.RepositoryImpl;
import com.aaron.system.log.model.SystemLog;

import java.util.List;

/**
 * Created by panzhuowen on 2016/3/4 001.
 */
@RepositoryImpl
public interface LogDao {

    int insertSystemLog(SystemLog systemLog);

    List<SystemLog> getSystemLogListPage(SystemLog systemLog);

}
