package com.springboot.springbootjpahikari.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Date: 2019/9/17 16:49
 * @Version: 1.0
 * @Desc:
 */
@Entity
@Data
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;
}
