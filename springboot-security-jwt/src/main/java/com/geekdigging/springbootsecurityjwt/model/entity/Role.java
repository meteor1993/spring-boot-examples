package com.geekdigging.springbootsecurityjwt.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 15:11
 * @email: inwsy@hotmail.com
 * Description:
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
