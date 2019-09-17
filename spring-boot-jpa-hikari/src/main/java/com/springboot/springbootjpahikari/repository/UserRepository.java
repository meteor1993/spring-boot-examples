package com.springboot.springbootjpahikari.repository;

import com.springboot.springbootjpahikari.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date: 2019/9/17 16:51
 * @Version: 1.0
 * @Desc:
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
