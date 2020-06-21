package com.geekdigging.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 0:54
 * @email: inwsy@hotmail.com
 * Description:
 */
public class AuthInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>AuthInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:Before invoking " + inv.getActionKey());
        inv.invoke();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>AuthInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:After invoking " + inv.getActionKey());
    }
}
