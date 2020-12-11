package com.vue.service;

import java.util.List;

import com.vue.entity.Book;

public interface BookService {
    List<Book> findAll();
}
