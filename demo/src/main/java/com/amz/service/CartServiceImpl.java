package com.amz.service;

import java.util.List;

import com.amz.dao.BookDAO;
import com.amz.dao.CartDAO;
import com.amz.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<Book> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public void save(Book book) {
        if(cartDAO.findOne(book)==null)
            cartDAO.save(book);
        else
            cartDAO.update(book);
    }

    @Override
    public void delete(String isbn) {
        cartDAO.delete(isbn);
    }

    @Override
    public void deleteAll() {
        cartDAO.deleteAll();
    }
}
