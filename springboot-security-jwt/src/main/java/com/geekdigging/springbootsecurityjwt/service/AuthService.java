package com.geekdigging.springbootsecurityjwt.service;

import com.geekdigging.springbootsecurityjwt.model.entity.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 20:10
 * @email: inwsy@hotmail.com
 * Description:
 */
public interface AuthService {
    User register(User userToAdd );
    String login( String username, String password );
}
