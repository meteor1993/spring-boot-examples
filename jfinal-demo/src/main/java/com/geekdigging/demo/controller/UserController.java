package com.geekdigging.demo.controller;

import com.geekdigging.demo.interceptor.AuthInterceptor;
import com.geekdigging.demo.model.User;
import com.geekdigging.demo.service.UserService;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 0:59
 * @email: inwsy@hotmail.com
 * Description:
 */
public class UserController extends Controller {

    @Inject
    UserService service;

    public void findById() {
        renderJson(service.findById("1"));
    }

    public void save() {
        User user = new User();
        user.set("id", "2");
        user.set("create_date", new Date());
        user.set("name", "小红");
        user.set("age", 24);
        service.save(user);
        renderNull();
    }

    public void update() {
        User user = new User();
        user.set("id", "2");
        user.set("create_date", new Date());
        user.set("name", "小红");
        user.set("age", 19);
        service.update(user);
        renderNull();
    }

    public void deleteById() {
        service.deleteById(getPara("id"));
        renderNull();
    }
}
