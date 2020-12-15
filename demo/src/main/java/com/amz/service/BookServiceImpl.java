package com.amz.service;

import java.util.List;

import com.amz.dao.BookDAO;
import com.amz.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void save(Book book) {
        if(bookDAO.findOne(book)==null)
            bookDAO.save(book);
        else
            bookDAO.update(book);
    }

    @Override
    public Book findOne(Book book) {
        return bookDAO.findOne(book);
    }

    @Override
    public void updateByCart(Book b) {
        bookDAO.updateByCart(b);
    }

}
