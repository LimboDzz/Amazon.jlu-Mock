package com.vue.controller;

import java.util.List;

import com.vue.entity.Book;
import com.vue.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("findAll")
    public List<Book> findAll(){
        List<Book> repo = bookService.findAll();
        System.out.println(repo);
        return repo;
    }


}
