package com.dbapp.spring.init;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @desc: Spring中Bean初始化的三种方法
 * @author: XT
 */
public class InitBean implements InitializingBean{

    public InitBean(){
        System.out.println("InitBean: constructor");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("InitBean: postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitBean: afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("InitBean: init-method");
    }
}
