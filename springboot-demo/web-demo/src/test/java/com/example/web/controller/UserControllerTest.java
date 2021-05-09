package com.example.web.controller;

import com.example.web.WebDemoApplicationTests;
import com.example.web.entity.Result;
import com.example.web.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserControllerTest extends WebDemoApplicationTests {

    @Autowired
    UserController userController;

    @Test
    void save() {
        User user = new User();
        user.setAge(11);
        user.setName("test");
        userController.save(user);
        Assert.assertTrue(true);
    }

    @Test
    void all() {
        Result all = userController.all();
        Assert.assertNotNull(all);
    }

    @Test
    void getUserByNameAndAge() {
        userController.getUserByNameAndAge("xizho", 1);
        Assert.assertTrue(true);
    }

}