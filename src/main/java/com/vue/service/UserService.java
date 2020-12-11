package com.vue.service;

import com.vue.entity.User;

public interface UserService {
    void save(User user);

	User login(String username, String password);
}
