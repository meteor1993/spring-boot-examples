package com.geekdigging.springbootsecurityjwt.repository;

import com.geekdigging.springbootsecurityjwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 15:40
 * @email: inwsy@hotmail.com
 * Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
