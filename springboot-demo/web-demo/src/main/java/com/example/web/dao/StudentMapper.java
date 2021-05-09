package com.example.web.dao;

import com.example.web.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends CrudRepository<Student, Integer> {
}
