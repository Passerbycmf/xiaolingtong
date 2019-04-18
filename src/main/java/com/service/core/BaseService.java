package com.service.core;

import java.io.Serializable;

/**
 * Created by lvjianqing on 2017/9/12.
 */
public interface BaseService<T, ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
