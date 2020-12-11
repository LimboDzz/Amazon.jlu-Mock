package com.vue.dao;

import java.util.List;
import com.vue.entity.Book;

public interface BookDAO {
    List<Book> findAll();
}
