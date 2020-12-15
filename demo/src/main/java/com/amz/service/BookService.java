package com.amz.service;

import java.util.List;

import com.amz.entity.Book;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findOne(Book book);

	void updateByCart(Book b);
}
