package com.geekdigging.demo.interceptor;

import com.jfinal.aop.Before;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 0:55
 * @email: inwsy@hotmail.com
 * Description:
 */
public class ActionInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>ActionInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:Before invoking " + inv.getActionKey());
        inv.invoke();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>ActionInterceptor>>>>>>>>>>>>>>>>>>>>>>>>>>>:After invoking " + inv.getActionKey());
    }
}
