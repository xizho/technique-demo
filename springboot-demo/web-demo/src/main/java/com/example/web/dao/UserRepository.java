package com.example.web.dao;

import com.example.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUserByNameAndAge(String name, Integer age);

    User getUserByName(String name);
}
