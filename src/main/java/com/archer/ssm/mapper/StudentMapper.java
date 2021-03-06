package com.archer.ssm.mapper;

import com.archer.ssm.bean.MapperStudent;


public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapperStudent record);

    int insertSelective(MapperStudent record);

    MapperStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapperStudent record);

    int updateByPrimaryKey(MapperStudent record);
}