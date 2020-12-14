package com.amz.service;

import java.util.List;

import com.amz.entity.Book;

public interface CartService {

	void save(Book book);

	List<Book> findAll();

	void delete(String isbn);

	void deleteAll();

}
