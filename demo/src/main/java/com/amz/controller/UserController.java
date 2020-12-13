package com.amz.controller;

import com.amz.entity.User;
import com.amz.service.UserService;
import com.amz.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("save")
    // @RequestBody接收前端传递的json字符串中的数据的(请求体中的数据)
    // GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交
    public Result save(@RequestBody User user) {
        Result result = new Result();
        try {
            us.save(user);
            result.setMsg("Successfully signed up.");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("Fail to sign up. Please try again.");
        }
        return result;
    }
}
