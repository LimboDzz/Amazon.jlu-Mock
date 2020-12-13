package com.amz.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;
import com.amz.entity.User;
import com.amz.service.UserService;
import com.amz.utils.ValidateImageCodeUtils;
import com.amz.vo.Result;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController return JSON data
@RestController
@RequestMapping("user")
// 8080 -> 4025
@CrossOrigin
public class UserController {
    @Autowired
    private UserService us;
    private User cur = null;

    public boolean isLogin() {
        return cur != null;
    }
    @PostMapping("save")
    // @RequestBody接收前端传递的json字符串中的数据的(请求体中的数据)
    // GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交
    public Result save(@RequestBody User user) {
        Result result = new Result();
        // System.out.println(us.findByUsername(user.getUsername()).size() > 0);
        if (!us.findByUsername(user.getUsername()).isEmpty()) {
            result.setStatus(false);
            result.setMsg("Username already exists. Please log in.");
            return result;
        } else {
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

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        Result result = new Result();
        List<User> res = us.findByUsername(user.getUsername());
        
        if(res.isEmpty() || !res.get(0).getPassword().equals(user.getPassword())){
            result.setStatus(false);
            result.setMsg("Wrong username or password. Please try again.");
        } else {
            // System.out.println(code);
            // System.out.println(code.equals(cc));
            cur = user;
            result.setMsg("Welcome " + cur.getUsername() + "!");
        }
        return result;
    }

}
