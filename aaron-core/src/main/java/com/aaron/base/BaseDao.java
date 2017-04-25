package com.aaron.base;

import com.aaron.annotation.RepositoryImpl;

import java.util.List;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/23
 * Time:19:22
 */
@RepositoryImpl
public interface BaseDao<T> {
    /**
     * 用于单表存储的实体
     * @param t 实体类
     */
    public void save( T t);

    /**
     * 用于单表更新数据
     * @param t 实体类
     */
    public void update(T t);

    /**
     * 通过主键删除数据
     * @param id 单表的主键
     */
    public void deleteByPrimaryKey(String id);

    /**
     * 通过主键查询数据
     * @param id
     * @return
     */
    public List<T> selectByPrimaryKey(String id);


}
