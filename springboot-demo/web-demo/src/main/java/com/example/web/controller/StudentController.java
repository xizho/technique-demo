package com.example.web.controller;

import com.example.web.entity.Student;
import com.example.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/save")
    public String insert(){
        Student student = new Student();
        student.setId(1);
        student.setAge(18);
        student.setGid(1);
        student.setName("xizho");
        student.setSex("male");

        studentService.insertStudent(student);

        return "SUCCESS";
    }
}
