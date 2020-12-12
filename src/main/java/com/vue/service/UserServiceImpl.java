package com.vue.service;

import java.util.UUID;

import com.vue.dao.UserDAO;
import com.vue.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
	
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user == null || !user.getPassword().equals(password))
            return null;
        else
            return user;
    }
}
