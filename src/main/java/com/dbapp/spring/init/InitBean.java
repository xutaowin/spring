package com.dbapp.spring.init;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @desc: Spring中Bean初始化的三种方法
 * @author: XT
 */
public class InitBean implements InitializingBean{

    public InitBean(){
        System.out.println("branch master InitBean: constructor");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("branch master InitBean: postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("branch master InitBean: afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println("branch master InitBean: init-method");
    }
}
