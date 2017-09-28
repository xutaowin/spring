package com.dbapp.junit;

import com.dbapp.spring.support.SpringContextHolder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/23
 * @Time： 15:37
 */
public class TestSpringContextHolder {
    @Test
    public void testGetBean(){
        //获取bean
        SpringContextHolder.getBean("testBean");
    }

    //以下为容器实例声明及初始化、销毁
    private ClassPathXmlApplicationContext context;

    @Before
    public void before(){
        try {
            // xml文件用逗号或者空格符隔开，均可加载
            context = new ClassPathXmlApplicationContext("spring-aware.xml");
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        context.destroy();
    }
}
