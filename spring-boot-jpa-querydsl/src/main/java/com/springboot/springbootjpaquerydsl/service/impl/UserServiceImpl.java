package com.springboot.springbootjpaquerydsl.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.springbootjpaquerydsl.dto.UserDTO;
import com.springboot.springbootjpaquerydsl.model.LessonModel;
import com.springboot.springbootjpaquerydsl.model.QLessonModel;
import com.springboot.springbootjpaquerydsl.model.QUserModel;
import com.springboot.springbootjpaquerydsl.model.UserModel;
import com.springboot.springbootjpaquerydsl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2019/9/25
 * @Time: 23:11
 * @email: inwsy@hotmail.com
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JPAQueryFactory queryFactory;

    @Override
    public Long update(String id, String nickName) {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.update(userModel).set(userModel.nickName, nickName).where(userModel.id.eq(id)).execute();
    }

    @Override
    public Long delete(String id) {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.delete(userModel).where(userModel.id.eq(id)).execute();
    }

    @Override
    public List<String> selectAllNameList() {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.select(userModel.nickName).from(userModel).fetch();
    }

    @Override
    public List<UserModel> selectAllUserModelList() {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.selectFrom(userModel).fetch();
    }

    @Override
    public List<UserDTO> selectAllUserDTOList() {
        QUserModel userModel = QUserModel.userModel;
        QLessonModel lessonModel = QLessonModel.lessonModel;
        return queryFactory
                .select(
                        Projections.bean(UserDTO.class, userModel.nickName, userModel.age, lessonModel.startDate, lessonModel.address, lessonModel.name)
                )
                .from(userModel)
                .leftJoin(lessonModel)
                .on(userModel.id.eq(lessonModel.userId))
                .fetch();
    }

    @Override
    public List<String> selectDistinctNameList() {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.selectDistinct(userModel.nickName).from(userModel).fetch();
    }

    @Override
    public UserModel selectFirstUser() {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.selectFrom(userModel).fetchFirst();
    }

    @Override
    public UserModel selectUser(String id) {
        QUserModel userModel = QUserModel.userModel;
        return queryFactory.selectFrom(userModel).fetchOne();
    }
}
