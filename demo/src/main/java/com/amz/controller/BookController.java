package com.amz.controller;

import java.util.List;

import com.amz.entity.Book;
import com.amz.service.BookService;
import com.amz.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController return JSON data
@RestController
@RequestMapping("book")
// 8080 -> 4025
@CrossOrigin
public class BookController {
    
    @Autowired
    private BookService bs;

    @GetMapping("findall")
    public List<Book> findAll() {
        // sessionCheck
        return bs.findAll();
    }

    @PostMapping("save")
    // @RequestBody接收前端传递的json字符串中的数据的(请求体中的数据)
    // GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交
    public Result save(@RequestBody Book book) {
        Result result = new Result();
        // System.out.println(us.findByUsername(user.getUsername()).size() > 0);
        try {
            bs.save(book);
            result.setMsg("Successfully stock in.");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("Fail to order. Please try again.");
        }
        return result;
    }
}
