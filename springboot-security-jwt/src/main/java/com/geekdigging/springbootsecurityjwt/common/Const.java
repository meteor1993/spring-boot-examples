package com.geekdigging.springbootsecurityjwt.common;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/10
 * @Time: 15:04
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Const {
    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "CodeSheepSecret";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
