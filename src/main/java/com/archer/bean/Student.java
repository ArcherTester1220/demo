package com.archer.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private List<BookInfo> infos;


    public Student() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BookInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<BookInfo> infos) {
        this.infos = infos;
    }
}
