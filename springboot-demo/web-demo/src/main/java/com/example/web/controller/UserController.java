package com.example.web.controller;

import com.example.web.config.annotation.MethodName;
import com.example.web.entity.Result;
import com.example.web.entity.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public Result all() {
        return userService.all();
    }

    @MethodName
    @GetMapping("/getUserByName")
    public Result getUserByName(String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/getUserByNameAndAge")
    public Result getUserByNameAndAge(String name, Integer age) {
        return userService.getUserByNameAndAge(name, age);
    }
}
