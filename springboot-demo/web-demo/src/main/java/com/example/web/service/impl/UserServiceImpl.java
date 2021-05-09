package com.example.web.service.impl;

import com.example.web.config.annotation.InstanceSelf;
import com.example.web.dao.UserRepository;
import com.example.web.entity.Result;
import com.example.web.entity.User;
import com.example.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @InstanceSelf
    private User user2;


    @Override
    public Result save(User user) {
        user2.setName(user.getName());
        user2.setAge(user.getAge());
        return new Result(userRepository.save(user2));
    }

    @Override
    public Result all() {
        return new Result(userRepository.findAll());
    }

    @Override
    public Result getUserByNameAndAge(String name, Integer age) {
        return new Result(userRepository.getUserByNameAndAge(name, age));
    }

    @Override
    public Result getUserByName(String name) {
        return new Result(userRepository.getUserByName(name));
    }
}
