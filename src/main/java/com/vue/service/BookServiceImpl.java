package com.vue.service;

import java.util.List;

import com.vue.dao.BookDAO;
import com.vue.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
    
}
