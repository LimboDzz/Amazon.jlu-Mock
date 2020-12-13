package com.amz.controller;

import com.amz.entity.User;
import com.amz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController return JSON data
@RestController
@RequestMapping("user")
// 8080 -> 4025
@CrossOrigin
public class UserController {
    @Autowired
    private UserService us;

    public void save(User user) {
        us.save(user);
    }
}
