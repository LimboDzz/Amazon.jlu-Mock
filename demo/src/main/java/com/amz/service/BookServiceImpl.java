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
        // sessionCheck
        return bookDAO.findAll();
    }
}
