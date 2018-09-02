package com.dbapp.spring.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @desc:
 * @author: XT
 */
public class HelloSpringLifeCycle implements InitializingBean,DisposableBean{
    @Override
    public void destroy() throws Exception {
        System.out.println("== destroy method ==");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("== init method ==");
    }
}
