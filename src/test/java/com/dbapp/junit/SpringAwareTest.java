package com.dbapp.junit;

import com.dbapp.spring.aware.MyApplicationContext;
import com.dbapp.spring.support.TestBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SpringAwareTest {

    private MyApplicationContext myApplicationContext;

    @PostConstruct
    public void init(){
        System.out.println("========SpringAwareTest init===========");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("==========setUp==========");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("==========tearDown==========");
    }

    @Test
    public void testAware() throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aware.xml");
        myApplicationContext = (MyApplicationContext)ctx.getBean("myContext");
        TestBean testBean = (TestBean)myApplicationContext.getBean("testBean");
        testBean.hello();
    }
}