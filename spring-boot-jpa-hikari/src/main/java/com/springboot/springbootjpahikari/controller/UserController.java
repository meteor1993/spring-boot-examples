package com.springboot.springbootjpahikari.controller;

import com.springboot.springbootjpahikari.model.UserModel;
import com.springboot.springbootjpahikari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("/user")
    public List<UserModel> user() {
        return userRepository.findAll(Sort.by("id").descending());
    }

    /**
     * 新增或更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/user")
    public UserModel user(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/user")
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "success";
    }
}
