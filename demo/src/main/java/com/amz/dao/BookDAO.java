package com.amz.dao;

import java.util.List;

import com.amz.entity.Book;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BookDAO {
    // return all books in repo
    List<Book> findAll();

	void update(Book book);

	Book findOne(Book book);

	void save(Book book);

	void updateByCart(Book book);

}
