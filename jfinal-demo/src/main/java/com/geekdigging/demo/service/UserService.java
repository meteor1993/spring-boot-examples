package com.geekdigging.demo.service;

import com.geekdigging.demo.model.User;
import com.jfinal.plugin.activerecord.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 15:37
 * @email: inwsy@hotmail.com
 * Description:
 */
public class UserService {

    private static final User dao = new User().dao();

    // 分页查询
    public Page<User> userPage() {
        return dao.paginate(1, 10, "select *", "from user where age > ?", 18);
    }

    public User findById(String id) {
        System.out.println(">>>>>>>>>>>>>>>>UserService.findById()>>>>>>>>>>>>>>>>>>>>>>>>>");
        return dao.findById(id);
    }

    public void save(User user) {
        System.out.println(">>>>>>>>>>>>>>>>UserService.save()>>>>>>>>>>>>>>>>>>>>>>>>>");
        user.save();
    }

    public void update(User user) {
        System.out.println(">>>>>>>>>>>>>>>>UserService.update()>>>>>>>>>>>>>>>>>>>>>>>>>");
        user.update();
    }

    public void deleteById(String id) {
        System.out.println(">>>>>>>>>>>>>>>>UserService.deleteById()>>>>>>>>>>>>>>>>>>>>>>>>>");
        dao.deleteById(id);
    }
}
