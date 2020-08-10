package com.geekdigging.springbootsecurityjwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 21:37
 * @email: inwsy@hotmail.com
 * Description:
 */
@RestController
public class TestController {
    // 测试普通权限
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @RequestMapping(value="/normal/test", method = RequestMethod.GET)
    public String test1() {
        return "ROLE_NORMAL /normal/test接口调用成功！";
    }

    // 测试管理员权限
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/admin/test", method = RequestMethod.GET)
    public String test2() {
        return "ROLE_ADMIN /admin/test接口调用成功！";
    }
}
