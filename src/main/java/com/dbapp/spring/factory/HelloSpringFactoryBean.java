package com.dbapp.spring.factory;

import com.dbapp.spring.demo.HelloSpring;
import org.springframework.beans.factory.FactoryBean;

/**
 * @desc:
 * @author: XT
 */
public class HelloSpringFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new HelloSpring();
    }

    @Override
    public Class<?> getObjectType() {
        return HelloSpring.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
