package com.vue.dao;

import com.vue.entity.User;

public interface UserDAO {
    void save(User user);
    
	User findByUsername(String username);
}
