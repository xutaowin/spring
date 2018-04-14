package com.dbapp.spring.dao.impl;

import com.dbapp.spring.dao.UserDao;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/16
 * @Time： 22:07
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("DB用户添加");
    }

    @Override
    public void update() {
        System.out.println("DB用户更新");
    }
}
