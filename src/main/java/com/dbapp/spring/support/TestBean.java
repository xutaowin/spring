package com.dbapp.spring.support;

import org.springframework.stereotype.Component;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/23
 * @Time： 15:31
 */
@Component("testBean")
public class TestBean {
    public TestBean(){
        System.out.println("TestBean 实例化。");
    }
}
