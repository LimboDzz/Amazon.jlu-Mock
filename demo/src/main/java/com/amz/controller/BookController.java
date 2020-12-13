package com.amz.controller;

import java.util.List;

import com.amz.entity.Book;
import com.amz.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
