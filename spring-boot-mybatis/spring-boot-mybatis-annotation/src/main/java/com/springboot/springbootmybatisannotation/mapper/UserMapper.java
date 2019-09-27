package com.springboot.springbootmybatisannotation.mapper;


import com.springboot.springbootmybatisannotation.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Version: 1.0
 * @Desc:
 */
public interface UserMapper {

    @Select("select * from users")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "age", column = "age"),
            @Result(property = "createDate", column = "create_date")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    User getUser(Long id);

    @Insert("INSERT INTO users(nick_name,age,create_date) VALUES(#{nickName}, #{age}, #{createDate})")
    Long insertUser(User user);

    @Update("UPDATE users SET nick_name = #{nickName},age = #{age} WHERE create_date = #{createDate}")
    Long updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    Long deleteUser(Long id);
}
