package com.dbapp.junit;

import com.dbapp.spring.context.DbappApplicationContext;
import com.dbapp.spring.context.support.ClassPathXmlDbappApplicationContext;
import com.dbapp.spring.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

public class DbappSpringBeansTest {

    //@Autowired
    private PersonService personService;
    @PostConstruct
    public void init(){
        System.out.println("========SpringBeansTest init===========");
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
    public void testConstructor() throws Exception {
        DbappApplicationContext ctx = new ClassPathXmlDbappApplicationContext("spring-beans.xml");
        personService = (PersonService)ctx.getBean("personService");
        personService.save();
    }
}