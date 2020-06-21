package com.geekdigging.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 23:04
 * @email: inwsy@hotmail.com
 * Description:
 */
public class ServiceInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>ServiceInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:Before invoking " + inv.getActionKey());
        inv.invoke();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>ServiceInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:After invoking " + inv.getActionKey());
    }
}
