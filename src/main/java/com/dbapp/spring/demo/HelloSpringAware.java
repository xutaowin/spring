package com.dbapp.spring.demo;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @desc:
 * @author: XT
 */
@Data
public class HelloSpringAware implements ApplicationContextAware,BeanFactoryAware{
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public Object getObjectByBeanFactory(String name){
        return this.beanFactory.getBean(name);
    }
    public Object getObjectByApplicationContext(String name){
        return this.applicationContext.getBean(name);
    }
}
