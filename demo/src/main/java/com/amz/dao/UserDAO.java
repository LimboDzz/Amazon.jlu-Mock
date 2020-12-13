package com.amz.dao;

import com.amz.entity.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    void save(User user);
}
