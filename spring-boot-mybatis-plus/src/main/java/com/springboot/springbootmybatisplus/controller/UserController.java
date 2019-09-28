package com.springboot.springbootmybatisplus.controller;

import com.springboot.springbootmybatisplus.mapper.UserMapper;
import com.springboot.springbootmybatisplus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/28
 * @Time: 23:30
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("getAll")
    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
