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
}
