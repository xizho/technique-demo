package com.example.other.test.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    private Integer age;
    private Boolean sex;
    //    private YearMonth birth;
    private Birth birth;
    private Date date;
}
