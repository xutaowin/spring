package com.dbapp.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/23
 * @Time： 15:03
 */
public class MyApplicationContext implements BeanNameAware,ApplicationContextAware {
    private ApplicationContext applicationContext;
    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("MyApplicationContext beanName:"+beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public Object getBean(String beanName){
        return this.applicationContext.getBean(beanName);
    }
}
