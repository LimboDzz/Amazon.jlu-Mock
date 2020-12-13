package com.amz.service;

import java.util.List;

import com.amz.entity.User;

public interface UserService {
    void save(User user);

    List<User> findByUsername(String name);
}
