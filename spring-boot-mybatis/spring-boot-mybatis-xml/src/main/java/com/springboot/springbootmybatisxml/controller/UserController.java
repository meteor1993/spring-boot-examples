package com.springboot.springbootmybatisxml.controller;

import com.springboot.springbootmybatisxml.mapper.UserMapper;
import com.springboot.springbootmybatisxml.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Version: 1.0
 * @Desc:
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userMapper.getAll();
    }

    @GetMapping("/getUser")
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @PostMapping("/add")
    public void save(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        userMapper.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.deleteUser(id);
    }
}
