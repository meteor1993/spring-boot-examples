package com.springboot.springbootmybatisxml.mapper;

import com.springboot.springbootmybatisxml.model.User;

import java.util.List;

/**
 * @Version: 1.0
 * @Desc:
 */
public interface UserMapper {

    List<User> getAll();

    User getUser(Long id);

    Long insertUser(User user);

    Long updateUser(User user);

    Long deleteUser(Long id);
}
