package com.dbapp.spring.service;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 21:54
 */
public interface StaffInfoService {
    String getStaffName(Integer staffId);
    void save(String staffName);
    void update(String staffName,Integer staffId);
}
