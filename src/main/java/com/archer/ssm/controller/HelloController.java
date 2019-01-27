package com.archer.ssm.controller;

import com.archer.annation.AopAnnation;
import com.archer.ssm.bean.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * SPRING AOP Test
 */
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    @AopAnnation
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/helloForm", method = RequestMethod.POST)
    @ResponseBody
    @AopAnnation
    public String helloForm(Student student) {
        return "name:" + student.getName() + "age:" + student.getAge();
    }


}
