package com.example.web.service;

import com.example.web.entity.Result;
import com.example.web.entity.User;

public interface UserService {

    Result save(User user);

    Result all();

    Result getUserByNameAndAge(String name, Integer age);

    Result getUserByName(String name);
}
