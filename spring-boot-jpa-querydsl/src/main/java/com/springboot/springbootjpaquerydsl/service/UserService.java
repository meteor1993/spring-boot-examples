package com.springboot.springbootjpaquerydsl.service;

import com.springboot.springbootjpaquerydsl.dto.UserDTO;
import com.springboot.springbootjpaquerydsl.model.UserModel;

import java.util.List;

public interface UserService {
    // 更新
    Long update(String id, String nickName);

    // 删除
    Long delete(String id);

    // 查询字段
    List<String> selectAllNameList();

    // 查询实体
    List<UserModel> selectAllUserModelList();

    // 查询实体并将结果封装至DTO
    List<UserDTO> selectAllUserDTOList();

    // 去重查询
    List<String> selectDistinctNameList();

    // 查询首个实体
    UserModel selectFirstUser();

    // 查询单个实体，如果结果有多个，会抛`NonUniqueResultException`。
    UserModel selectUser(String id);
}
