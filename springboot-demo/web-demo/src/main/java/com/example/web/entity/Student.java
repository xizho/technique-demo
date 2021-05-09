package com.example.web.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "sid")
    private Integer id;

    @Column(name = "sname")
    private String name;

    @Column(name = "gid")
    private Integer gid;

    @Column(name = "sage")
    private Integer age;

    @Column(name = "ssex")
    private String sex;

}
