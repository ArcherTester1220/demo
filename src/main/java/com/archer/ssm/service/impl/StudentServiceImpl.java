package com.archer.ssm.service.impl;


import com.archer.ssm.bean.MapperStudent;
import com.archer.ssm.mapper.StudentMapper;
import com.archer.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(MapperStudent record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(MapperStudent record) {
        return mapper.insertSelective(record);
    }

    @Override
    public MapperStudent selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MapperStudent record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(MapperStudent record) {
        return 0;
    }
}
