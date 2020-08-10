package com.geekdigging.springbootsecurityjwt.service.impl;

import com.geekdigging.springbootsecurityjwt.model.entity.User;
import com.geekdigging.springbootsecurityjwt.repository.UserRepository;
import com.geekdigging.springbootsecurityjwt.service.AuthService;
import com.geekdigging.springbootsecurityjwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 20:10
 * @email: inwsy@hotmail.com
 * Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if( userRepository.findByUsername(username) != null ) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword( encoder.encode(rawPassword) );
        return userRepository.save(userToAdd);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken( username, password );

        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername( username );
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }
}
