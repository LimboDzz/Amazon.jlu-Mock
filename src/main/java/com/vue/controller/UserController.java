package com.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
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
    public String login(@RequestBody User user, HttpSession session) {
        User res = userService.login(user.getUsername(), user.getPassword());
        System.out.println(res);
        if (res!=null) {
            session.setAttribute("user", res);
            System.out.println("1111");
            return "redirect:/admin.html";
        } else {
            return "redirect:/index.html";
        }
    }
}
