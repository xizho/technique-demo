package com.example.other.test.model;

import lombok.Data;

import java.util.Date;

@Data
public class People {
    private String name;
    private Integer age;
//    private YearMonth birth;
    private Birth birth;
    private Boolean sex;
    private Date date;
}
