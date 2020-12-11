package com.vue.controller;

import com.vue.entity.User;
import com.vue.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    // @RequestBody 作用在形参列表上，将前台发送过来的json封装为对应的JavaBean
    public void save(@RequestBody User user) {
        // System.out.println(user);
        userService.save(user);
    }

    @PostMapping("login")
    // @RequestBody 作用在形参列表上，将前台发送过来的json封装为对应的JavaBean
    public User login(@RequestBody User user) {
        System.out.println(user.getPassword());
        return userService.login(user.getUsername(), user.getPassword());
    }
}
