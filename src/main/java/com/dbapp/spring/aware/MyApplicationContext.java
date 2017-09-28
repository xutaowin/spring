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
    private String beanName;
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("MyApplicationContext beanName:"+beanName);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //通过重写的接口方法，获取spring容器实例context，进而获取容器中相关bean资源
        System.out.println(applicationContext.getBean(this.beanName));
    }
}
