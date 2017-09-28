package com.dbapp.spring.proxy;

import com.dbapp.spring.service.UserService;
import com.dbapp.spring.service.impl.UserServiceImpl;

/**
 * @desc: 静态代理
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:03
 */
public class StaticProxy implements UserService{

    private UserService userService;

    public StaticProxy(UserService userService){
        this.userService = userService;
    }

    public void add() {
        System.out.println("添加日志开始");
        userService.add();
        System.out.println("添加日志结束");
    }

    public void update() {

    }
}
