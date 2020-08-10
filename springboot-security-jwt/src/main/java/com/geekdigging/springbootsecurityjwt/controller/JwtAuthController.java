package com.geekdigging.springbootsecurityjwt.controller;

import com.geekdigging.springbootsecurityjwt.model.entity.User;
import com.geekdigging.springbootsecurityjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 21:36
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class JwtAuthController {
    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    // 注册
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }
}
