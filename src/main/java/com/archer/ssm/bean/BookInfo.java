package com.archer.ssm.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class BookInfo {
    private String bookName;

    public BookInfo() {
    }
}
