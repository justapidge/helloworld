package com.iweb.test3;

/**
 * @author wmn
 * @date 2023/11/25 11:02
 */
public class UserServiceImpl2 implements UserService{
    @Override
    public void login() {
        System.out.println("扫掌登录");
    }

    @Override
    public void register() {
        System.out.println("扫屁股注册");
    }
}
