package com.example.web.service.impl;

import com.example.web.config.annotation.InstanceSelf;
import com.example.web.dao.StudentMapper;
import com.example.web.entity.Student;
import com.example.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @InstanceSelf
    private Student student;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return (List<Student>) studentMapper.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.findById(id).orElse(null);
    }
}
