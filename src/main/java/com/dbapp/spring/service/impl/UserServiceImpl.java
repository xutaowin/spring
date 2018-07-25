package com.dbapp.spring.service.impl;

import com.dbapp.spring.dao.UserDao;
import com.dbapp.spring.service.UserService;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:07
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(){
        System.out.println("创建Bean");
    }

    public void add() {
        System.out.println("SERVICE用户添加");
        //userDao.add();
    }

    public void update() {
        System.out.println("SERVICE用户更新");
        userDao.update();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
