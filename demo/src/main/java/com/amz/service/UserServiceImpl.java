package com.amz.service;

import java.util.List;
import java.util.UUID;

import com.amz.dao.UserDAO;
import com.amz.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void order(User cur) {
        userDAO.order(cur);
    }
}
