package com.example.web.service;

import com.example.web.entity.Student;

import java.util.List;

public interface StudentService {

    void insertStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> getStudent();

    Student getStudentById(Integer id);
}
