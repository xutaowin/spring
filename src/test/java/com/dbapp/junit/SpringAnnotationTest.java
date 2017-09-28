package com.dbapp.junit;

import com.dbapp.spring.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SpringAnnotationTest {

    //@Autowired
    private PersonService personService;
    @PostConstruct
    public void init(){
        System.out.println("========SpringAnnotationTest init===========");
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
    public void testAnnotationConfig() throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-annotation.xml");
        personService = (PersonService)ctx.getBean("personService");
        personService.save();
        ctx.close();
    }

    @Test
    public void testComponentScan() throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-annotation.xml");
        personService = (PersonService)ctx.getBean("personService");
        personService.save();
        ctx.close();
    }
}