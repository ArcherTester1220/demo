package com.archer.ssm.controller;


import com.archer.annation.TimerAnnotion;
import com.archer.ssm.bean.MapperStudent;
import com.archer.ssm.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        MapperStudent student = new MapperStudent();
        student.setName("zhang3");
        student.setAge(11);
        int i = studentService.insertSelective(student);
        return i > 0 ? "success" : "fail";
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    @TimerAnnotion
    public MapperStudent queryById(@PathVariable Integer id) {
        MapperStudent student = studentService.selectByPrimaryKey(id);
        return student;
    }


}
