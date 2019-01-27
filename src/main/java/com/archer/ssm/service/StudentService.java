package com.archer.ssm.service;

import com.archer.ssm.bean.MapperStudent;

public interface StudentService {

    int deleteByPrimaryKey(Integer id);

    int insert(MapperStudent record);

    int insertSelective(MapperStudent record);

    MapperStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapperStudent record);

    int updateByPrimaryKey(MapperStudent record);

}
