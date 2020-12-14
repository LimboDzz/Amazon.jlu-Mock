package com.amz.dao;

import java.util.List;

import com.amz.entity.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    void save(User user);

    List<User> findByUsername(String name);

	void order(User cur);
}
