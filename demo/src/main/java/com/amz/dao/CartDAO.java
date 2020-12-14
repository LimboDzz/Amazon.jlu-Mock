package com.amz.dao;

import java.util.List;

import com.amz.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartDAO {

	List<Book> findAll();

	Object findOne(Book book);

	void save(Book book);

	void update(Book book);

	void delete(String isbn);

	void deleteAll();

}
