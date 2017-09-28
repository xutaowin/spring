package com.dbapp.spring.service.impl;


import com.dbapp.spring.service.StaffInfoService;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 21:53
 */
public class StaffInfoServiceImpl implements StaffInfoService {

    private String user = null;

    public StaffInfoServiceImpl(){

    }

    public StaffInfoServiceImpl(String user){
        this.user = user;
    }

    public String getStaffName(Integer staffId) {
        System.out.println("我是StaffInfoServiceImpl的getStaffName()方法!");
        return "xutao";
    }

    public void save(String staffName) {
        //throw new RuntimeException();
        System.out.println("我是StaffInfoServiceImpl的save()方法!");
    }

    public void update(String staffName,Integer staffId) {
        System.out.println("我是StaffInfoServiceImpl的update()方法!");
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
